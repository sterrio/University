# Stephen Terrio, B00755443 - CSCI 2202 Lab 4
# Taking in a set of numbers and finding the largest and smallest.

#Packages
import math
import numpy as np

# Taking in the inputs and converting them to floats
x, y, z = input("Enter the three numbers (seperated by a space): ").split()
x = float(x)
y = float(y)
z = float(z)

# Declarations to be used to save findings.
arr = np.array([x,y,z])
smallest = x
largest = x

# Looping through inputs, finding the samllest/biggest
for i in range(3):
    if(arr[i] < smallest):
        smallest = arr[i]
    if(arr[i] > largest):
        largest = arr[i]
print("The largest number input is",largest, "and the smallest",smallest)
