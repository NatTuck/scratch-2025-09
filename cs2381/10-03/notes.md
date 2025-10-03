
# New Kind of Data Structure: Set

- Collection of items
- Doesn't allow (or ignores) duplicates
- Order doesn't matter

Implementation plan A: Use any list.

Set operations:

- add
- remove
- size
- contains

Mathematical set operations:

- union
- intersection
- difference (which one?)
- complement (tricky)
- subset?
- superset?

Proposed implementation:

- Idea: Binary Search ; Sorted ArrayList
  - add: O(n)
    - Search for the spot. O(log n)
    - Push everything after down one. O(n)
    - idea: When we double the list size, put nulls between each entry
  - remove: O(n)
    - Search for the spot. O(log n)
    - After removing, need to shift everything after back. O(n)
    - idea: When removing, replace with null
  - size = O(1)
  - contains = O(log n)

- ConsList; same as array list
- ArrayList (no duplicates)
  - add = if not contains, add ; O(n)
  - remove = remove ; O(n)
  - size = size ; O(1)
  - contains = contains ; O(n)
- ArrayList (with duplicates)
  - add = add ; Amortized O(1)
  - remove = removeAll ; O(n)
  - size is: hard ; O(n^2)
    set tmp = empty()
    count = 0
    for (x : mySet) { // O(n) * O(n)
      if (!tmp.contains?(x)) { // O(n)
        tmp.add(x)
        count += 1
      }
    }
  - contains = contains ; O(n)

Problem: Duplicates, either:
 - Add needs to check contains first.
 - removeAll


## Mutable vs Immutable Sets


```java
interface ImmutableSet<T> {
  ImmutableSet<T> add(T item);
  ImmutableSet<T> remove(T item);
  int size();
  boolean contains(T item);
}

interface MutableSet<T> {
  void add(T item);
  void remove(T item);
  int size();
  boolean contains(T item);
}


```
## How to build the Math operations from the basic ops

- C = union(A, B) - add gets called O(n) or O(n + m) times.
  - C = {}; for (x: A) { C.add x }; for (x: B) { C.add x }
- C = intersection(A, B) 
  - C = {}; for (x : B) { if (A.contains?(x)) { C.add(x) } } 
- difference (which one?)
  - A and not B
  - C = A; for (x : B) { C.remove(x); }
- complement (tricky; optional, coincidentally, not implemented)
- A.subsetOf?(B) => boolean
  - for(x : A) { if (!B.contains(x)) { return false; } }; return true;
- supersetOf?
  - for(x : B) { if (!A.contains(x)) { return false; } }; return true;
- Exercise for the reader: What's the difference between proper and improper
  supersets / subsets?













