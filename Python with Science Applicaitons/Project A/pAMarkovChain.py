# Stephen Terrio, B00755443
# Project A - Page Rank Simulation - Markov Chain:

# Packages -
import numpy as np
import math
import random as rand
from projectA import adjMatrixFromFile
from projectA import outDegrees # Imported functions from previous file -
from projectA import transitionProbabilities
from projectA import transposeMatrix

# Change this to the corresponding file name  -
file = 'tiny.txt'

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
    resultMatrix[1][0] += 1
    pT = transposeMatrix(trPM)
    vector = transposeMatrix(resultMatrix)
    for i in range(numTrials):
        vector = np.matmul(vector, pT)
    resultMatrix = vector
    return resultMatrix

print("Ranks: \n", markovCrawl(adjM, trPM, mMatrix, numTrials))
