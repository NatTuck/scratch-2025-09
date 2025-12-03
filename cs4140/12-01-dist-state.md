
# Distributed State

## First

- Last 3 lectures: Today, Review, Playtest
- Remember to bring computer on Friday for playtest.

## Topic

### Byzantine Generals

Let's say Byzantium is having a war with Persia.

Four Byzantine Generals, each leading an army of 10,000 men, have
surrounded a Persian army of 30,000.

If the four generals attack at the same time, they'll probably win.

If less than 3/4 attack, the Persians will probably win.

- If any single general thinks that any one the other generals won't
  attack, he's better off not attacking.

The ranking general plans to attack at dawn. He sends a messenger to
each of the other generals with his plan/orders for them to attack.

Dawn comes.

Should he attack?

What if a messenger was killed? Two messengers?

**New plan**

Head general sends messages to other generals: Attack at dawn,
send return message to confirm.

He gets back three confirmations. Should he attack?

Should general #2 attack? What if his reply messenger was killed?

What if general #1 gets only one confirmation?

  Order ->
  Confirm <-
  Acknowledge Confirmation (and count of confirmations) ->

This is basically the same problem as writes in a distributed
data store.

Complicated protocols for this include RAFT.

**More Complicated**

So we have order, confirmation, conf-ack.

- What if one of the 4 generals has been bribed by the Persians? He'll never
attack, but always says he will.

How does this happen in computer systems?

- Malware
- Cheating

## Examples

Every web app is:

- A distributed system
- With at least one untrusted node

**Online Slot Machine**

App server stores:

- User's token balance
- Slot machine jackpot quantity
- Result of latest spin

Browser stores:

- User's token balance
- Slot machine jackpot quantity
- Result of latest spin
- Current visual / interactive state
  - Between spins
  - Wheel positions

Data should almost exclusively flow server -> browser.

Problem: What if app server goes down?

- The app doesn't work.
- As a good first reaction, we probably shouldn't try to
  make this app work offline.

**Online Poker Game**

Clearly Texas Holdem.

App server stores:

(secret info)

- Deck cards
- Cards each player has

(public info)

- Shared, revealed cards
- Current player balances
- Current player bets

Browsers store:

- Current player's cards.
- Public info

To do this fully distributed, we'd need some sort of mechanism
for secret computation.

**More Complicated**

Shared document editing:

- We've got one text document.
- Several users can edit it at the same time.
- We want to allow offline edits.

Problem:

- Two people make offline changes and both come online.
- What does the document look like?

Unfortunately, there's no general correct solution.

Simpler case first:

- Sports stadium
- Two entrances
- People at the door have hand click counters to
  count people entering.
- We can just add the numbers together.

Another simpler case:

Shared address book.

- A contact is {name, phone #}
- Alice adds {Bob, 555 1212}
- Carol adds {Bob, 555 8139}
- What's Bob's phone number in the address book?
- Simplest solution:
  - Include timestamp with changes.
  - Latest change wins.
  - Break ties arbitrarily.


Document case again:

- We're writing an essay on a novel as a team.
- Alice writes the part on chapters 1-10.
- Bob writes the part on chapters 9-18.








