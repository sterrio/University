# Stephen Terrio, B00755443

# Packages -
import numpy as np
from numpy.linalg import matrix_power
import math

# Problem 1 A -
# 2 x 2 matrix G, where G = [[1,1],[1,0]] (base value)
ogMatrix = np.matrix([[1,1],[1,0]])

# [1,0]- Transposed
matrixT = np.matrix([1,0]).T

for i in range(8):
    matrixNew = ogMatrix.dot(matrixT) # finding next Fib values
    current = i + 1 # current fib step
    print("STEP: " ,current, "\n" ,matrixNew) # printing
    matrixT = matrixNew # Setting old values to new values for next step

# Problem 1 B -
threeM = matrix_power(ogMatrix,3)
fiveM = matrix_power(ogMatrix,5) # Using power function to calculate G^x
tenM = matrix_power(ogMatrix,10)

print("\nPOWER: 3", threeM)
print("POWER: 5", fiveM) # Print
print("POWER: 10", tenM)

# The pattern of these numbers are also the Fibbonaci sequence !
