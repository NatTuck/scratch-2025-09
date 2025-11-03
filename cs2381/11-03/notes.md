
# Bloom Filter

What's a bloom filter?

- Structure to approximate set membership.
  - No false negatives.
  - Maybe false positives.
- Operates by having a bitset, where we set bits
  based on the hash of the elements we add
- More than one hash
  - Reduces the chance of false positives for
    a fixed number of bits stored.

# Bit Arrays as Sets

Pizza Toppings

- Pepperoni (bit 0)
- Pineapple (bit 1)
- Sausage   (bit 2)
- Bacon     (bit 3)

Represent a set of pizza toppings as a 4 bit number.

A = Pepperoni Pizza: 0001
B = Bacon and Pineapple: 1010

C = A union B     = A | B
D = A intersect B = A & B

## Problem: Blocking Phishing Sites

- Mozilla Firefox wanted to introduce a feature to block
  known phishing sites.
- They had a list, updated every day, of about 100,000
  domain names.
- Plan A: Query Mozilla server before visiting any
  web site.
- Problem: Mozilla users in ~2012 thought that privacy
  mattered.
- Plan B: Send the list of domains to every user every day.
- Problem: 10 * 100,000 = 1 MB
- Idea: Hash the domains, give users a list of 32-bit hashes.
- Problem: Collisions:
  - We can just query the Mozilla server with the real domain.
- Problem 2: 400k is still a bit too big.
- Idea: Use a 16-bit hash instead.
  - Now it's not 1 in 10 million is a collision, it's 2/3.

## Approximate Set

- Data structure
- has contains? operation
- false means false
- true could be false positive

## More ideas

- Idea: Bit set of hashes?
- Problem: That's 512MB.
- Idea: Smaller hashes - 24 bits would give 1% false positive rate.
- Problem: 3 * 100 = 300k

## Bloom Filters

- Idea: Use more than one hash.

## Example

- Assume we have two hash functions, h1 and h2, which
  are independent.
- To insert an item in to the filter (bit set of both hash
  outputs) we:
  - calculate h1(K), insert that bit
  - calculate h2(K), insert that bit
- To check for membership, we calculate both hashes and check
  both bits
  - If either bit isn't there, we're sure K wasn't inserted.
- Collisisons are less likely, so at a given size we:
  - Multiply the probabilities (drastically lowering collision
    chance).
  - Account for multiple bits inserted (moderately raising)
