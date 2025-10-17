# Lab 08: Sets, Maps, and Trees

In this lab you will work on various stuff related to Sets, Maps, and Trees.

Feel free to put whatever you want in App#main for experimentation.

## Problems

**Problem 1. WordCount**

Complete the code in WordCount.java to determine word counts for the
provided text files using the supplied TreeMap implementation.

**Problem 2. ConsMap**

Complete the code in ConsMap.java to build a Map data structure using
a ConsList.

**Problem 3. Complete set operations for ConsSet**

In ConsSet.java, complete the following methods:

- ConsCell#add
- ConsCell#remove
- ConsCell#union
- ConsCell#intersection
- ConsCell#isSuperset
- ConsCell#isSubset

For this implementation of a set using the structure of a ConsList,
the items must be stored in ascending order. Otherwise the #equals
method won't work correctly.

**Problem 4. Complete the Iterator for BinTree**

In BinTree.java, complete the BinTreeIterator#next method.

The plan is:

- If the current node is a leaf:
  - Pop the top item from the path stack.
  - That's the item to return.
  - The next item will be its right child.
- If the current node is not a leaf:
  - Go left as far as you can, pushing each node you
     don't stop at onto the path stack.
  - That's the item to return.
  - The next item will be its right child.

This is the same sequence as a recursive in-order traversal, just
making the call stack explicit so we can do one step at a time.

**Problem 5. Complete set operations for TreeSet**

In TreeSet.java, complete the following methods: add,
remove, union, intersection, isSuperset, isSubset

**Problem 6. Answer questions**

Edit the QUESTIONS.md file, answering the included questions.

**Problem 7. Scapegoat Tree**

Modify the code in TreeMap.java to keep the tree balanced using the
Scapegoat Tree strategy.

**Problem 8. Anything Else**

Fix up anything else so the perl test script passes.
