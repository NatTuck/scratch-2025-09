
# How Computers Execute Programs

Two stories

## What the hardware does

- CPU - Central Processing Unit
- RAM - Random Access Memory
  - In a Von Neumann architecture computer, stores
    both code and data
- We load / store data at memory addresses

Execution loop (what the CPU does)

- Load an instruction from memory (at the program counter)
- Run that instruction
- Increment the program counter, to point to the next
  instruction
- Repeat

## How a Lua program works

We have:

- Lines of code
- Functions
- Variables

Operation of the Lua "Notional Machine":

- Executes lines of code, top to bottom.
- Both variables and functions have names.
- We have different "environments" which names exist in.
