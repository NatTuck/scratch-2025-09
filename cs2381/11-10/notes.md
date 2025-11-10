
## Priority Queues

- Default queues are FIFO
- A priority queue lets higher priority things go first.

Application examples:

- Lines at Disney World
- Network Routers
- Some pathfinding algorithms (e.g. Djkstra's or A*)
- OS Scheduling

Operations:

- insert(item, priority)   (traditionally, low number is higher priority)
- next()   (returns first in item among highest priority)

## How to build priority queue

- Sorted association list (linked list)
  - Insert is O(n)
  - Next is O(1)
- Binary tree ordered by (priority, insertion order)
  - Insert is O(log n)
  - Next is O(log n)
- Heap
  - Insert is O(log n)
  - Next is O(log n)

## Heap

- Complete binary tree
  - "Complete" means that each row gets filled before the next
    row starts.
- Min-heap property: Parent is smaller than either child.
- This is a tree, so we end up with O(log n) operatoins.

Optimized implementation: Array-mapped heap.

- Store our nodes in a single array (really, ArrayList)
- xs(0) is root
- For index ii, children are (2*ii+1) and (2\*ii+2)

Insertion:

- Insert at end (that's O(1) in ArrayList)
- Compare to parent and sibling, maybe swap.
- If swap, recurse.
- Until root.

Find smallest and remove.

- Smallest is root is index 0.
- Swap root with last leaf.
- That lets us remove it in O(1) time.
- But now root might not be smallest, so we need to fix it.
- If root bigger than any child, swap root with smallest child.
- If swap, recurse.
- Until leaf.

There are some fancy variants with better asymptotic complexity,
but probably worse performance on small-ish data.

## Graphs

A Graph is:

- A set of vertices, v in V
- A set of edges, e in E, (E subset VxV), (e in VxV)
