
# Data Structure Design

Application: Text Editor

How do we store the text in the currently open file?

- A String
- An arraylist of strings, one per line
  - Delete one line is O(n)
- Binary Search Tree, Keys: integer line numbers
  - Delete one line is O(n)

```
1: Dear Bob,
2:
3: I'm sorry to inform you
4: that your dog Muffins has
5: died.
7:
8: Sincerely,
9: 
10: Alice
```

- Doubly linked list of strings, where we keep a reference to the
  current cursor line.
  - Delete current line is O(1)
  - Move to line by line number is O(n)

- Binary Tree without keys, lines in file order.
  - Each node has a size, so we can find lines by their line
    number in O(log n) time.
  - Delete current line (or by line number) O(log n)
  - Move to line by number. O(log n)
  - Make a new line O(log n) - (find number, update sizes)
  - Modify current line - O(1)
  - Copy - O(1) / O(log n)
  - Paste - O(log n) - O(1) existing operations that are O(log n)
  - Find / Replace - O(n)
    - Optimize: Add a word / triplet index
  - This family of data structures (tree of strings) is called a
    Rope, and is pretty common for text editors.

The problem:

- We open a file
  - Optimally, this is O(1)
  - Bad news: We haven't done C or OS yet, so we can't do this
    in O(1). We'll assume this is O(n).
  - Because this is O(n), we can construct a data structure
    that takes O(n) or even O(n log n) to construct.
- We make some series of edits
  - Optimally, each is O(1), or at least O(log n)
- We save the file
  - Optimally, in O(1)
  - Again, we have no trick to avoid writing every byte to
    disk, so this is O(n)
  - Because this is O(n), we can traverse a data structure
    that takes O(n) or even O(n log n) to traverse.
