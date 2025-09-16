
## Where are we?

In Java, List is an interface. Every List has
a bunch of standard methods.

Two (main) concrete list types in Java stdlib:

- ArrayList:
  - get(ii), set(ii, val) is O(1)
  - add(val) is **amortized** O(1)
- LinkedList - a doubly linked list
  - get(ii), set(ii, val) is O(n)
  - add(val) is O(1)

Example sort algorithm: Bubble Sort

- O(n^2) if swap is O(1)
- O(n^3) if swap is O(n)

We're working on another list now: ConsList




