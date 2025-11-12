# How to represent a graph

```
class Graph:
  vertices: Set<String> 
  edges: Set<(String, String)>
```

Example: Graph of course prereqs

Operations:

- Find parents
  - Two sets is O(n)
- Find children
  - Two sets is O(n) - maybe better with multiple binary searches

```
# Math way
class Graph:
  vertices: Set<String> 
  forward_edges: Set<(String, String)> (sorted on parents)
  backward_edges: Set<(String, String)> (sorted on children)
```

```
# Maps way
class Graph:
     kids: Map<String, Set<String>> (parent name to child names)
     parents: Map<String, Set<String>> (parent name to child names)
```

```
# Native graph way
class Graph:
    nodes: Set<Node>

class Node:
    name: String
    parents: Set<Node>
    children: Set<Node>
```

```
# Indirect graph way
class Graph:
    nodes: Set<Node>

class Node:
    name: String
    parents: Set<String>
    children: Set<String>
```
