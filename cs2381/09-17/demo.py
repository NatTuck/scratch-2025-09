
import math

def log2(x):
    return math.log(x) / math.log(2)

def f(x):
    return math.sqrt(x)
    #return x**49

def g(x):
    return log2(x)
    #return 2**x

for ii in range(0, 10):
    x = 10**ii
    print(f"{x}\t{f(x)}\t{g(x)}")
