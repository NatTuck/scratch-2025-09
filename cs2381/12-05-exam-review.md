
# Exam Review

Monday, 11-1:30pm, here

1. In the SeaApp#main method, what is the type of the args parameter?

String[]

2. In the SeaApp#main method, what is the type of the nums variable?

ArrayList<Integer>

3. If we run the SeaApp program, what will it print?

squid => 18, crab => 3

4. What is the asymptotic complexity of the SeaApp#squid method? Why?

O(n^2) - Method runs O(n) times, most expensive line (remove) is O(n).

5. What is the asymptotic complexity of the SeaApp#crab method? Why?

We loop through the list once, each iteration does O(1) stuff, so O(n).

6. What is the asymptotic complexity of the SeaApp#tuna method? Why?

O(n^2). Most expensive operation is squid, which is O(n^2).

7. How many bytes does it take to store the declared fields of a Pair record? Why?

8; 2 ints, 4 bytes each

8. Why is the complexity of ArrayList#add “amortized” O(1) rather than just O(1)?

Because it has to grow sometimes.

9. What are the names and descriptions for the standard operations for a Stack?

- pop - take item off top of stack
- peek - look at next item without removing it
- push - put item on top
- size - gets the size
- isEmpty - check if it's empty

(probably -1 for missing peek, need one of size/isEmpty)

10. How is a Stack different from a Queue?

Stacks operate at one end.

Queues operate at both ends - put on one end, pull from the other

11. If a multithreaded program that makes good use of many cores takes 12 seconds on 12 processor cores, how long would you expect it to take on 6 cores? Why?

24 seconds; half the workers doubles the time

12. Write the body of SeaApp#keepUnique. This should return a new List, not modify the input, and run in O(n) time in the size of the input.

```java
    static List<Integer> keepUnique(List<Integer> xs) {
      var stuff = new HashSet<Integer>();
      var ys = new ArrayList<Integer>();

      for (var x : xs) {
        if (!stuff.contains(x)) {
          stuff.add(x);
          ys.add(x);
        }
      }

      return ys;

       // Build and return a new ArrayList containing
       // each item from xs only once.
       
       // Examples: 
       //  - keepUnique([1,1,1,1,1,2,1,1,2]) -> [1,2]
       //  - keepUnique([1,2,1,5,3,2,3,4,5]) -> [1,2,5,3,4]
    }
```

13. Give one example of a type in Java that is not a primitive type.

Integer
String

14. What are two effects of declaring a type as a record rather than as a class?

- immutable
- creates getters for each field
- creates hashCode, toString, ...
- Declaration is the constructor

15. Why might you want to use a TreeSet instead of a HashSet?

- If you want the keys sorted.
- To guarantee O(log n) performance even in the face of bad / unlucky
  / malicous inputs.
- Key type has no hashCode, but does have compareTo.
- If we never want linear time add, due to realtime constraints.
