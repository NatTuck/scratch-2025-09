
# Two remaining topics

- Performance of in-browser code.
- Performance of server-side code.

## In Browser

Two issues:

- JS execution time during page load
- Performance of long-running JS

Code execution time is a standard program optimization problem.

How to fix slow code:

- Do we need to run this code at all? Do we need to run it right now?
- Optimizations:
  - Can we do less work?
    - Better data structure or algorithm? Can we get better asymptotic
      complexity?
    - Can we work on less data?
  - Heroic optimization
    - Multi-threading?
      - In browsers, these are "web workers", which are effectively
        separate JS runtimes with message passing and sometimes crazy
        hacks for shared memory.
    - Vectorization
    - WebGPU
    - WebAssembly
      - Either custom C / Rust code
      - Or just pulling in optimized C / Rust Libraries
- Biggest thing for JS code specifically:
  - Make event handlers fast.
  - Same as for most interactive UI apps.

## Making server-side code fast

Two cases:

- Part of a network request / response.
  - Whatever request latency we have on the server is going to
    stack with network latency.
  - Really want to fit our processing in less than ~50 ms.
  - What we need to do in that time:
    - Parse request.
    - Route the request.
    - Fetch / write any data from / to the DB.
    - Do any data processing that we need to do.
    - Generate a response.
  - Transfer time also stacks, but typically is fast
    after first request.
- Asynchronous tasks.
  - How long can this task take?
  - How much of our server is this using up?
