
## 09-22: Stacks

- A list is a sequence of items, and a bunch of associated operations.


A Stack is a sequence of items with only a few operations.

Specifically, you can only access a stack at one end (the "top").

Basic operations:

- push - Add item to top
- pop - Remove item from top (and get it).
- isEmpty - Check if stack is empty

Stacks commonly have two more operaitons:

- peek - Get top item without removing it.
- size - Get size.

```java
interface Stack<T> {
  void push(T item); // Add item to top.
  T pop(); // Get top item (removing it from stack).
  boolean isEmpty(); 
}
```





