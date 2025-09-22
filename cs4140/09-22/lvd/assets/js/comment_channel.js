
import $ from 'cash-dom';

import socket from './user_socket';

let channel = null;

function showComments(xs) {
  let div = document.getElementById('chan-comments');

  let lines = "";

  for (let comment of xs) {
    lines += `<p>- ${comment}</p>\n`;
  }

  div.innerHTML = `
    <div>
      ${lines}
    </div>
  `;
}

function init() {
  let form = document.getElementById('chan-form');
  if (!form) {
    return;
  }
  channel = socket.channel("comments:demo", {})
  channel.join()
   .receive("ok", resp => { console.log("Joined successfully", resp) })
   .receive("error", resp => { console.log("Unable to join", resp) })
  
  form.addEventListener('submit', (ev) => {
    ev.preventDefault();

    let inp = document.getElementById('comment-input');
    let text = inp.value;
    channel.push("comment", {text})
      .receive("ok", (xs) => showComments(xs));

    inp.value = "";
  });
}

$(init);
