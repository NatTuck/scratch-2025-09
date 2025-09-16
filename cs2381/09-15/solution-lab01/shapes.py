#!/usr/bin/env python

from math import pi

class Circle:
    def __init__(self, rad):
        self.radius = rad

    def area(self):
        return pi * pow(self.radius, 2.0)

class Square:
    def __init__(self, ww):
        self.width = ww

    def area(self):
        return self.width * self.width


s1 = Circle(1)
s2 = Square(1)
s3 = Circle(2)
s4 = Square(2)

shapes = [s1, s2, s3, s4]

for shape in shapes:
    print("Area of shape is", shape.area())



