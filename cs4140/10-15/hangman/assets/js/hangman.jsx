import React, { useState, useEffect } from 'react';
import { createRoot } from 'react-dom/client';
import $ from 'cash-dom';

import socket from "./user_socket";

let channel = null;

function Hangman(_props) {
  const [word, setWord] = useState(random_word());
  const [guesses, setGuesses] = useState(new Set());

  let letters = new Set("abcdefghijklmnopqrstuvwxyz".split(""));
  let remaining = letters.difference(guesses);

  useEffect(() => {
    channel = socket.channel("game:lobby");
    channel.join()
      .receive("ok", (resp) => {
        console.log("Joined successfully:", resp);
      });
  }, []);

  function click_guess(letter) {
    let gs1 = new Set(guesses);
    gs1.add(letter);
    setGuesses(gs1);
  }

  let guess_links = Array.from(remaining).map((letter) => (
    <a href="#" key={letter} onClick={() => click_guess(letter)}>{letter}</a>
  ));

  let bad_guesses = guesses.difference(new Set(word.split("")));

  function reset() {
    setWord(random_word());
    setGuesses(new Set());
  }

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-200">
      <div className="bg-white p-8 rounded-lg shadow-lg text-center">
        <p className="text-4xl mb-4 font-bold">Hangman</p>
        <p className="text-3xl tracking-widest mb-6">{showGuessed(word, guesses)}</p>
        <p className="text-xl">Bad guesses: {Array.from(bad_guesses).length}</p>
        <p className="text-xl">{guess_links}</p>
        <p className="mt-6">
          <button
            onClick={reset}
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full transition-colors duration-300 ease-in-out"
          >
            Reset Game
          </button>
        </p>
      </div>
    </div>
  );
}

function showGuessed(word, guesses) {
  let letters = word.split("");
  let result = [];
  for (let ch of letters) {
    if (guesses.has(ch)) {
      result.push(ch);
    }
    else {
      result.push("_");
    }
  }
  return result.join(" ");
}

const words = [
  "jazz",
  "buzz",
  "jinx",
  "quiz",
  "fjord",
  "lymph",
  "crypt",
  "gawk",
  "hajj",
  "fluff",
  "nymph",
  "rhythm",
  "syzygy",
  "awkward",
  "bagpipes",
  "banjo",
  "beekeeper",
  "blizzard",
  "bookworm",
  "boxcar",
  "buckaroo",
  "cobweb",
  "croquet",
  "dwarves",
  "embezzle",
  "fishhook",
  "flapjack",
  "frazzled",
  "gazebo",
  "glowworm"
];

function random_word() {
  return words[Math.floor(Math.random() * words.length)];
}

function connect() {
  let channel = socket.channel("game:lobby", {})
  channel.join()
    .receive("ok", resp => { console.log("Joined successfully", resp) })
    .receive("error", resp => { console.log("Unable to join", resp) })
}


function init() {
  var root_div = document.getElementById('hangman-root');
  if (!root_div) {
    return;
  }

  const root = createRoot(root_div);
  root.render(<Hangman />);
}

$(init);
