# Stephen Terrio, B00755443
# Seismic Data Linear Matrix Regression -

# Packages -
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import math

# Importing the same way as LabB1 - except using csv instead
dataXY = pd.read_csv('SovietWeaponsTest.txt')
dataXY.head()
myDataArray=np.array(dataXY)

# We now have a string array of inputs -> need to convert to values

x = len(myDataArray) # getting length of value array
Magnitued = [] # list to hold Mag values
Yield = [] # list to hold Yield values

# Splitting the string values stored in index i and converting them to floats to be stored in vol/pres lists
for i in range(x):
    y = myDataArray[i][0].split('\t') # splitting
    Magnitued.append(float(y[1])) # converting and storing
    Yield.append(float(y[5])) # converting and storing

print('Magnitued: ')
print(Magnitued)

print('Yield: ')
print(Yield)

# TRANSFORM X - CONVEX DOWN - Lower value of Yield - using Log(10)X
yNew=[]
for i in range(len(Yield)):
    yNew.append(math.log(Yield[i],10))
Yield = yNew

# Plotting y vs x -
plt.scatter(Magnitued, Yield, color='blue')
plt.show()

# Matrix Regression -
Vmatrix=np.vstack((np.ones(len(Yield)), Yield)).T
# Using formula -> ((X-transpose * X)-inverse)*(X-transpose*Y)
beta = np.linalg.inv(Vmatrix.T.dot(Vmatrix)).dot(Vmatrix.T).dot(Magnitued)
print("Using Matrix Regression...")
print(beta)

# Finding hat
yHat = [beta[0] + beta[1] * i for i in Yield]
plt.scatter(Yield, Magnitued)
plt.plot(Yield, yHat, color='red') # Superposing line
plt.show()

# Calculating the residiuals -
ei=[] # Using to store ei values
for i in range(len(Yield)):
# ei = yi - yhats
    ei.append(Magnitued[i] - yHat[i])

plt.scatter(ei, Magnitued, color='red') # Superposing line
plt.show()
