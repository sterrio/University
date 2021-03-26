# Stephen Terrio, B00755443

# Packages -
import matplotlib.pyplot as plt
import numpy as np
from numpy.linalg import matrix_power
import math

# Given info
p = 0.104
population = [[20,40],[35,40],[45,40],[60,40],[80,40]]

# Defining lists to store values
owls=[]
rats=[]

# 50 different monthsfor time 't', filling in array to keep track -
months=[]
for i in range(0,50):
    months.append(i)

# getting the 'last' value of each population to continue off of
for count in population:
    owl=count[0]
    rat=count[1]

# Appending those values to respective list as a starting point
owls.append(owl)
rats.append(rat)

# calculating each value based for months 1 - 50 (already have index 0)
for k in range(1,50):
    oSN = owl
    rSN = rat

    owl = 0.5 * rSN +0.4 * rSN # From formula
    rat= -p * oSN + 1.1 * rSN # From formula

    owls.append(owl)
    rats.append(rat)

# Using subplot before first graph
plt.subplot(1,2,1)

# Owls[i] vs Rats[i] pop
plt.plot(owls,rats,color = 'red')
plt.show()

# Using second subplot before second graph
plt.subplot(1,2,2)
# Owl pop vs. Rat pop
plt.plot(months,owls,'r-',months,rats,'b--')
plt.show()
