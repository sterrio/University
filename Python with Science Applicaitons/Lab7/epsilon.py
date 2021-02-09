# Stephen Terrio, B00755443, CSCI 2202 - Lab 7
# Machine Epsilon Testing

# Packages
import math

# PART I -
Epsilon = 7.8 + 0.2 + 8.9 - 2.1
# We find from this that the answer is not what it should be and is instead 14.799999999999999

# Finding the exact machine epsilon:
machineEps = 1
result = 1;
while((result + machineEps) != 1):
    machineEps = machineEps/2

print("The Machine Epsilon is:", machineEps)
# This results in the machine epsilon being found to be: 1.1102230246251565e-16

# PART II - Values match when they should be different - Revist
p = 0.01
iteration = 0
for i in range(0,50,1):
    verhulst = p+3*p*(1-p)
    verhulstSecond = (1+3)*p-3*(p)**2
    difference = verhulst - verhulstSecond
    p+=i
    print("The first is %12.12f The second is %12.12f The difference is %12.12f" %(verhulst, verhulstSecond, difference))
    if iteration == 0 and difference != 0:
        iteration = i
        print("DIFFERENCE OCCURED:iteration %d" %i)
# The answers start to differ at iteration 2, however this is only noticed if we observe 16 places after the decimal,
# Therefore, only observing 12 places after the decimal, we only see the first difference at iteration 10
