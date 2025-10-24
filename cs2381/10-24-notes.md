# Maps

Two common map types:

- Balanced Binary Search Tree
  - put: O(log n), get: O(log n)
  - ordered keys
  - Can be mutable or immutable and efficiently persistent.
  - Cache friendlyness: D tier, too many links
- Hash Table
  - put: expected, amortized O(1), get: expected O(1)
  - unordered (because hash function should look random)
  - Must be mutable (or do a full copy)
  - Cache friendlieness: good

Less common types:

- Any List of Key-Value Pairs
  - put: O(n), get: O(n)
  - ...
- Sorted Array List of Key-Value Pairs
  - put: O(n), get: O(log n)
  - ordered, because it's sorted
  - immutable: put: O(n), get: O(log n)
  - cache friendliness: good, it's an array
- Skip List
  - put: O(log n), get: O(log n)
  - ordered, because it's sorted
  - must be mutable
  - cache friendliness: bad, it's a bunch of little nodes.
- Trie
  - put: O(key.size()), get: O(key.size())
  - ordered
  - can be immutable and efficiently persitent
  - not cache friendly

Trie vs BST (keys are single English words)

- Plausible english words: len <= log(4096)
- n = 1, log(n)~=1, typical word = 6,
- n = 64k, log(n)~16

## Classification / Considerations

- Asymptotic complexity of operations (mostly put, get)
- Is the structure mutable, or is it immutable and persistent.
- Ordered vs unordered keys
  - Frequently O(log n) vs O(1)
- Cache friendlyness / other real hardware considerations

## Two New Map Structures

- B-Tree
- Compact Trie (patricia tree)
