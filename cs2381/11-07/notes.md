
## Data Races and Deadlock

Data race can happen when there is:

- Concurrent execution
- Shared data
- A write

Solution: Mutex

Problem with one mutex: That makes program sequential

More mutexes?

### Building a Banking Server

- An object: Alice's Account (balance = $100)
- An object: Bob's Account (balance = $100)

```java
void transfer(Account a1, Account a2, int dollars) {
  synchronized(a1) {
    synchronized (a2) {
      int t1 = a1.getBalance();
      t1 = t1 - dollars;
      if (t1 < 0) { throw new Exception("Not emough money."); }

      int t2 = a2.getBalance();
      t2 = t2 + dollars;

      a1.setBalance(t1);
      a2.setBalance(t2);
    }
  }
}

void thread1() {
  transfer(alice, bob, 10);
}

void thread2() {
  transfer(bob, alice, 5);
}
```

Deadlock!

Condition for deadlock:

- Circular wait

To avoid:

- Don't have more than one mutex.
  - Now our program is sequential.
  - All Python programs work this way.
- Never have a single thread try to take more than
  one mutex.
- Carefully enforce a lock ordering rule (there's a total
  order on every mutex, and mutexes are always taken in
  order).
- Don't use the mutex concept as your way to coordinate
  threads and avoid data races.
