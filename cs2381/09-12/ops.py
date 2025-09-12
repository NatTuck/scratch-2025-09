#!/usr/bin/env python

from math import log

def log2(x):
    return log(x)/log(2.0)

slow_ops = 0

def slow_add(ii):
    global slow_ops

    # Copy whole array
    slow_ops += ii

double_ops = 0

def double_array(ii):
    global double_ops

    # Copy if ii is a power of two
    if ii == 2*int(log2(ii)):
        double_ops += ii
    else:
        double_ops += 1

best_ops = 0

def best_case(_ii):
    global best_ops

    # Copy nothing
    best_ops += 1


nn = 10

for ii in range(0, 10):
    slow_add(nn)
    double_array(nn)
    best_case(nn)

print("slow: ", slow_ops)
print("doub: ", double_ops)
print("best: ", best_ops)


