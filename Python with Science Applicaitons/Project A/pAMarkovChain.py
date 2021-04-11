# Stephen Terrio, B00755443
# Project A - Page Rank Simulation - Markov Chain:

# Packages -
import numpy as np
import math
import random as rand
import matplotlib.pyplot as plt
from projectA import adjMatrixFromFile
from projectA import outDegrees # Imported functions from previous file -
from projectA import transitionProbabilities
from projectA import transposeMatrix

# Change this to the corresponding file name  -
file = 'medium.txt'

# Getting User Input for number of trials performed
numTrials = int(input("Enter the number of Trials: "))

# Function Calls -
adjM = adjMatrixFromFile(file)
degM = outDegrees(adjM)
trPM = transitionProbabilities(adjM, degM)
mMatrix = transposeMatrix(trPM)

# Simulating Web Crawler based on PDF description -
def markovCrawl(adjM, trPM, mMatrix, numTrials):
    # Initializing vector x0
    resultMatrix = np.zeros((len(adjM),1))
    for i in range((len(adjM))):
        tempMatrix = np.zeros((len(adjM),1))
        tempMatrix[i][0] += 1
        vector = transposeMatrix(tempMatrix)
        for j in range(numTrials):
            vector = np.matmul(vector, mMatrix)
        # Filling result matrix with values
        for k in range(len(adjM)):
            resultMatrix[i][0] = vector[0][0]
    return resultMatrix

markovM = markovCrawl(adjM, trPM, mMatrix, numTrials)
print("Ranks: \n", markovM)

plt.hist(markovM, len(markovM))
plt.xlabel("Ranks")
plt.ylabel("Appearance Amount")
plt.show()
