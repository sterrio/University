# Stephen Terrio, B00755443 - CSCI 2202 Lab 4
# Solving a list of x-values with henons algorithm and comparing the results.

#Packages
import math

#Using g value as a "guess"
g = 1
eps = 1.e-5
xList = [10,20,30,40,50,60,70,80,90]

for i in range(9):
    #Loop using henon's g guess value until g^2 is equal to val
    while abs(g*g - xList[i]) > eps:
        g = (g+xList[i]/g)/2
        #Using a temporary value to keep track of index root
        temp = math.sqrt(xList[i])
        #printing out each value.
    print("Actual value: ", temp, "Henon's value: ", g)
