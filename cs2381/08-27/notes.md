
# cs2381, Lecture 2

## The Java Programming Language

In Python, program is:

- A collection of modules, each in its own file.
- A module contains statements, including statements
  defining functions and classes.
- One module is the main module of the program.
- Some statements can calls conditional, repeated, or
  delayed execution.
- But aside from that, the program starts at the first statement
  in the main module and runs statements in order top top bottom.

```python
# greet.py
def greet(name):
  print("Greetings, " + name)

greet("Alice")
greet("Bob")
```


```java
// Greet.java
public class Greet {
  public static void main(String[] _args) {
    greet("Alice");
    greet("Bob");
  }

  static void greet(String name) {
    System.out.println("Greetings, " + name);
  }
}
```

A Java program is:

- A collection of packages, each in its own directory.
- Each package contains a collection of classes, some
  of which get their own file.
- A class contains methods.
  - There are no functions (for now), just methods.
- Methods contain statements.
- Every program has a main class.
- Excution starts at the main method of the main class,
  and statements execute in order.

## Data Types (in python)

- Primitive types
  - Number (int vs. float)
  - String
  - boolean
- Tuples
- Classes / Instances
- Lists
- Dictionaries
- Sets

## Data Types (in Java)

- Primitive types
  - integers: byte, short, int, long
  - floats: float, double
  - boolean
  - char (actually, just another int)
- A special thing called an array
- class instances
- Native class types
  - String
  - Class wrappers: Int, Float
- Library classes
  - various kinds of List, Dictionary, and Set
- User defined classes
  - Special way to do that: Records



