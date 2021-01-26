# Stephen Terrio, B00755443 - CSCI 2202 Lab 4
# Taking in an input and finding the root via Henon's algorithm

#Packages
import math

#Input
val = int(input("Enter the value: "))

#Using g value as a "guess"
g = 1
eps = 1.e-5

#Loop using henon's g guess value until g^2 is equal to val
while abs(g*g - val) > eps:
    g = (g+val/g)/2

#Return g
print(g)
