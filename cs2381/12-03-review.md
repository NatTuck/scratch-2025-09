
# Semester Review

## This class

- Title: Intermediate Programming and Data Structures

Intermediate Programming:

- Programming that's harder than the last class
- Programming paradigm: Object Oriented
- Explicit, checked types
- We built our own data structures
- Our programs had more than one file
- We used Maven, an "enterprise grade" packaging and build tool
- We dealt with moderately complex automated tests

Data structures:

- We built our own data structures
- Look at a bunch of common and uncommon kinds of data structures:
  - arrays (mostly as a building block)
  - Lists
    - Singly linked (cons), Doubly Linked, ArrayList
  - Maps, Sets
    - Trees, Skip Lists, Tries, Hash Trie, Hash Table
    - Hash functions
  - Stacks, Queues, Deques
  - Priority Queues
    - Heaps
  - BitSet / Bit Lists
- Asymptotic Complexity
  - Which thing is faster?
  - When? On what computer?
  - Is there anything we can say that's more universal?
  - Which thing will get slower faster as the size of the
    problem increases?
  - Comparing growth rates of functions:
    - f(x) = 3x + 7
    - f(x) = x^23 - 342221
  - Largest term wins.
  - We can classify functions by their largest term:
    - O(2^n) > O((n^2)(log(n))) > O(n^2) > O(n) > O(sqrt(n)) > O(log(n))
  - We can classify algorithms into those categories.
  - Algorithms like "Insert a key into a balanced binary search tree".

## New Language: Java

- Explicit, checked types
- Really likes classes, uses them for everything
- Looked at types in the language
  - Primive types: int, float, ...
  - Pop quiz: How many bytes is a double?
  - Built in complex types: String ...
  - User defined types: class ..., record ...
- Javadoc
- Style checking rules
- Some common libaries, especially Junit for testing.

Design recipie for classes:

- A Java program is a bunch of classes.
- To write a java program, you write all the classes.
- To write a class, you write a bunch of methods.
- You figure out the structure of a method by looking at
  what it can see (arguments, class fields).
- Methods on recursive data are probably recursive in the
  same way.

Threads and concurrency:

- Modern processors are multi-core, we'd like to use them
  to make our programs faster.
- That typically means multiple threads.
- Threads in the same process share memory.
- Concurrency + shared memory + mutation = data race = data corruption.
- Mutexes help, but get us deadlocks.

LLMs:

- Using them to write code.
- Writing code that uses them.
