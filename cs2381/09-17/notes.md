

- O(n)
- O(n^2)


## Growth of Functions

f(x) = x + 23
f(x) = (x^2)/7 + 43x - 9
f(x) = (2^x) + x^49 - 12

How to compare:

- We only care about the highest degree term.
- We can throw away coefficients. 

(example: 3x^4 + 444x^2 + 9   => x^4)
(example: 397 => 1)

## Which term is higher?

- 0
- 1
- log2(x)
- sqrt(x)
- x 
- x * log2(x)
- x * sqrt(x)
- x^2
- x^3
- x^(some power higher than 3)
- 2^x
  - x = 40 might be okay
  - x = 80 is impossible


## What's that big-O thing?

When we say: f(x) is O(g(x))

That means:

 - There is some constant k and some value for x (x0) such that
   f(x) <= k*g(x) for all x > x0.


Example: 100*x is O(x^2)

Proof: x0 = 101, k = 1

Example: 100*x is O(x)

Proof: x0 = 1, k = 101

**So big-O means**

We can wordify f is O(g) as: The function f is asymptotically 
bounded above by the function g.

Other bounds:

 - big-Omega is used for a bound from below.
 - big-Theta is a tight bound on both sides.

When we say: f(x) is big-Omega(g(x))

That means:

 - There is some constant k and some value for x (x0) such that
   f(x) >= k*g(x) for all x > x0.


When we say: f(x) is big-Theta(g(x))

That means: f(x) is O(g(x)) and f(x) is big-Omega(g(x))







