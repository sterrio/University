#Stephen Terrio, B00755443
# Lab 8 - Quadratic Roots

# Packages
import math
import turtle
import numpy as np
import random as rand
import matplotlib.pyplot as plt

# Select operations from math library that need to be specified as included
from math import log
from math import sin
from math import tan

# Function to check for complex Roots
def hasComplex(a,b,c):
    # Only checking inside the root as that is the only place that could cause undefined roots
    return ((b**2-4*a*c)<0)
n = 1000

# Running for n simulations and keeping track of the amount of roots found using counter
complexCount = 0
for i in range(n):
    a = rand.random()
    b = rand.random()
    c = rand.random()
    if hasComplex(a,b,c):
        complexCount = complexCount + 1
# Finding the probability using our count and total simulations
complexProb = complexCount/1000
print("The function after 1000 simulations found", complexProb, "complex probability")

# For Uniform, new Vars to keep use as counter--
uniCount = 0
for i in range(n):
    # Abs to make sure our values are generating as positives with normalvariate
    a = abs(rand.normalvariate(0,1))
    b = abs(rand.normalvariate(0,1))
    c = abs(rand.normalvariate(0,1))
    if hasComplex(a,b,c):
        uniCount = uniCount + 1
# Finding the probability using our count and total simulations
uniProb = uniCount/1000
print("The uniform function after 1000 simulations found", uniProb, "uniform probability")

## PART II --
# Tolerance being set to 10^-8
def bisection(f, x0,x1,tol=1e-8, m = 0):
    # where x0 and x1 are endpoints, f is the function, and tolerance is equvialent to value shown in lab pdf
    if f(x0) * f(x1) > 0 and (x1-x0)>tol:
        print("Invalid range for roots\n")
        return
    # checking base cases (where function returns 0)
    if f(x0)==0: return x0,0
    if f(x1)==0: return x1,0
    root = x0
    rootAttempts = 0
    # Setting m to ln(x1 - x0) - ln(tolerance)/ln2
    m = (log(x1-x0)-log(2*tol))/log(2)
    # Approximating the root while x1+x0 is less than given tolerance.
    while (x1-x0) >= tol and rootAttempts <= m:
        # Dividing by two each loop and changing type to account for decimals
        root = (x1+x0)/2.0
        if f(root)*f(x0) < 0:
            x1 = root
        else:
            x0 = root
        rootAttempts = rootAttempts+1
    # Returning the root value and the iteration count it took to find it
    return root, rootAttempts

# Calculating for interval [1,2]
# Using lambda x: to store a temp value of x for function use
f = lambda x: x**2-x-1
# Interval Value
x0 = 1
x1 = 2
# f will represent our functions that we pass in; such as x**3-3*x-1
root, rootAttempts = bisection(f, x0, x1)
print('(%f, %f): Root: %.4f, iterations: %d'%(x0,x1,root, rootAttempts))

# Now for interval [-1, 0]
x0 = -1
x1 = 0
root, rootAttempts = bisection(f, x0, x1)
print('(%f, %f): Root: %.4f, iterations: %d'%(x0,x1,root, rootAttempts))

# Calculating for the functions
f1 = lambda x: x**3 - 3 * x-1
x = np.linspace(-2,2,100)
plt.plot(x,[f1(i) for i in x])
plt.show()

x0 = -1
x1 = 0
root, rootAttempts = bisection(f1, x0, x1)
# Once again using abs to account for the |f(x)| in the required output
print('Range: [%f, %f]: x: %.4f, f(x): %e, iterations: %d '%(x0,x1,root, abs(f1(root)), rootAttempts))

f2 = lambda x: x**3-2*sin(x)
x = np.linspace(-2,2,100)
plt.plot(x,[f2(i) for i in x])
plt.show()

x0 = 0.5
x1 = 2
root, rootAttempts = bisection(f2, x0, x1,)
print('Range: [%f, %f]: x: %.4f, f(x): %e, iterations: %d '%(x0,x1,root, abs(f2(root)), rootAttempts))

f3 = lambda x: tan(x)-2*x
x = np.linspace(-2,2,100)
plt.plot(x,[f3(i) for i in x])
plt.show()

x0 = 0
x1 = 2
root, rootAttempts = bisection(f3, x0, x1)
print('Range: [%f, %f]: x: %.4f, f(x): %e, iterations: %d '%(x0,x1,root, abs(f3(root)), rootAttempts))
