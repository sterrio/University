# Stephen Terrio, B00755443
# Lab D part 2 -

# Packages -
import numpy as np
import math

# Part 1 --
# Function provided: (1/x) - will use this to calculate integral
def func(x):
    result =  1/x
    return result

def trapezoidal(func,a,b,n):
    delX = (b - a) / n # Interval Length Formula
    itgr = func(a) + func(b) # Getting sum of function f on a & b
    # Looping through sub-intervals (left end-point & right end-point)
    for i in range(1,n):
        currLength = a + delX * i
        itgr = itgr + func(currLength) * 2
    # Using the final itgr value to calculate most accurate integration at endpoint
    result = itgr * delX/2
    return result

# Part 2 --
#Midpoint formula from PDF
def midpoint(func,a,b,n):
    result = 0
    iL = (b - a) / n  # Interval Length
    # looping through sub - steps and calculating
    for i in range(n):
        result += iL * func(a + iL * (i - 1))
    return result

# Creating Main function -
def main():
    # Information from PDf: lower = 1, upper = 2,
    lower = 1 # lower limit
    upper = 2 # upper limit

# Creating lists to store error values
    trapErr = []
    midErr = []
    exact = np.log(2) # Natural log of 2 for exact value

    n = 2 # Starting interval (increases by * 5's)
    count = 0 # Keeping track of number of N tests
    while(count < 5):
        # Call trapezoidal() method and get result
        result = trapezoidal(func,lower,upper,n)
        error = exact - result
        trapErr.append(error)
        n = n * 5
        count = count + 1

    # Resetting and testing for midpoint
    n = 2
    count = 0
    while(count < 5):
        # Call midpoint() method and get result
        result = midpoint(func,lower,upper,n)
        error = exact - result
        midErr.append(error)
        n = n * 5
        count = count + 1

# PRINTING -
# Array of different N's to be tested and stored in the tables -
    n = [2,10,50,250]
# Handling trapezoidal table -
    print("\nTrapezoidal: ")
    print("n\tError\t\t\tRatios")
    for i in range(0,3):
        ratioErr = trapErr[i]/trapErr[i+1]
        print("%d\t %0.7f\t \t%0.7f" %(n[i],trapErr[i],ratioErr))
# Cannot retrieve further val as there is no more adjacent
    ratioErr = trapErr[3]
    print("%d\t %0.7f\t \t%0.7f" %(n[3],trapErr[3],ratioErr))
# Handling Midpoint Table -
    print("\nMidpoint: ")
    print("n\tError\t\t\tRatios")
    for i in range(0,3):
        ratioErr = midErr[i]/midErr[i+1]
        print("%d\t %0.7f\t \t%0.7f" %(n[i],midErr[i],ratioErr))
# Cannot retrieve further val as there is no more adjacent
    ratioErr = midErr[3]
    print("%d\t %0.7f\t \t%0.7f" %(n[3],midErr[3],ratioErr))
# Running Main method
main()
