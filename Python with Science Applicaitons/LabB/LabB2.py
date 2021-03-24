# Stephen Terrio, B00755443
# Matrix Regression to a Linear Model -

# Packages -
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import math

# Importing the same way as LabB1 - except using csv instead
dataXY = pd.read_csv('Boyle_P-V.txt')
dataXY.head()
myDataArray=np.array(dataXY)

# We now have a string array of inputs -> need to convert to values

x = len(myDataArray) # getting length of value array
volume = [] # list to hold volume values
pressure = [] # list to hold pressure values

# Splitting the string values stored in index i and converting them to floats to be stored in vol/pres lists
for i in range(x):
    if(i!=0):
        y = myDataArray[i][0].split('\t') # splitting
        volume.append(float(y[0])) # converting and storing
        pressure.append(float(y[1])) # converting and storing

print('volume: ')
print(volume)

print('pressure: ')
print(pressure)

# Removing problem elements from lists -
volume.remove(12.0)
pressure.remove(117.6)
volume.remove(13.0)
pressure.remove(107.8)
volume.remove(14.0)
pressure.remove(100.4) # These elements increase exponentially compared to the others
volume.remove(15.0)
pressure.remove(93.1)
volume.remove(16.0)
pressure.remove(87.9)
volume.remove(17)
pressure.remove(82.8)

# TRANSFORM Y - i.e pressure  USING CONVEX UP (Y down // X down)
pressurenew=[]
for i in range(len(pressure)):
    pressurenew.append(math.log(pressure[i],10))
pressure = pressurenew

# Part 1 - Complete
plt.scatter(pressure, volume)
plt.show() # We can see here that the model is more exponential than it is linear.

# Matrix Regression -
Vmatrix=np.vstack((np.ones(len(volume)), volume)).T
# Using formula -> ((X-transpose * X)-inverse)*(X-transpose*Y)
beta = np.linalg.inv(Vmatrix.T.dot(Vmatrix)).dot(Vmatrix.T).dot(pressure)
print("Using Matrix Regression...")
print(beta)

# Part 2 - Complete
pHat = [beta[0] + beta[1] * i for i in volume]
plt.scatter(volume, pressure)
plt.plot(volume, pHat, color='red') # Superposing line
plt.show()

# Calculating the residiuals -
ei=[] # Using to store ei values
for i in range(len(volume)):
# ei = yi - yhat
    ei.append(pressure[i] - pHat[i])

# Scatter plot of pHat vs. ei
plt.scatter(pHat,ei, color='blue')
plt.show()
