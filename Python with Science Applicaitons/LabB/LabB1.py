# Lab B - Stephen Terrio, B00755443
# Matrix Regression

# Packages -
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import math

 # Reading excel sheet
dataXY = pd.read_excel('IrisData_slr10.xls')
dataXY.head()
myDataArray=np.array(dataXY)

# Filling arrays for later use
x=myDataArray[:,0] # Pulling the first column to be used as X
y=myDataArray[:,1] # Pulling the second column to be used as Y

#Matrix Regression using 𝛽 =(𝑋𝑇*𝑋)−1 * (𝑋𝑇*𝑌)
Xmatrix=np.vstack((np.ones(len(x)), x)).T
# Using formula -> ((X-transpose * X)-inverse)*(X-transpose*Y)
beta = np.linalg.inv(Xmatrix.T.dot(Xmatrix)).dot(Xmatrix.T).dot(y)
print("Using Matrix Regression...")
print(beta)

# Using results from regression as intercept & coefficient for y hat
# yHat = b0 + b1 + xi
yHat = [beta[0] + beta[1] * i for i in x]

# Residiuals -
ei=[] # Using to store ei values
for i in range(len(x)):
# ei = yi - yhat
    ei.append(y[i] - yHat[i])

#Graph of predicted line vs values found in sheet
plt.scatter(x, y) # Showing point values of x and y
plt.plot(x, yHat, color='red') # Superposing line
plt.show()

# Ensuring they are NP arrays..
ynp = np.array(y)
xnp = np.array(x)
ei_np = np.array(ei)

#plotting ei vs y and ei vs x
plt.plot(ei_np,ynp, color='red')
plt.plot(ei_np ,xnp, color='blue')
plt.show()
