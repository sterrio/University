# Stephen Terrio, B00755443 - CSCI 2202 Lab 4
# Computing pi based on the number of n inputs

#Packages
import math

#Input
n = int(input("Enter the number of n terms: "))
pi = 0
pi = float(pi)
op = "pos"

# Looping through the sequence "n" times to calculate pi
for i in range(1,n,2):
    # Even index is negative
    if op == "neg":
        pi = pi - 1/i
        op = "pos"
    # Every uneven index is positive
    elif op =="pos":
        pi = pi + 1/i
        op = "neg"
#Handling the 4* of the formula
pi = pi*4
print(pi)
