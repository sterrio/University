# Stephen Terrio, B00755443
# Project A - Page Rank Simulation - Random Crawler:

# Packages -
import numpy as np
import math
import random as rand
import matplotlib.pyplot as plt
from projectA import adjMatrixFromFile
from projectAMod import adjMatrixFromFileMod
from projectA import outDegrees # Imported functions from previous file -
from projectA import transitionProbabilities

# Change this to the corresponding file name  -
file = 'medium.txt'

# Getting User Input for number of trials performed
numTrials = int(input("Enter the number of Trials: "))

# Function Calls -
adjM = adjMatrixFromFile(file)
degM = outDegrees(adjM)
trPM = transitionProbabilities(adjM, degM)

# Simulating Web Crawler based on PDF description -
def crawl(adjM, degM, trPM, numTrials):
    # Defining PageRank Matrix
    pageMatrix = np.zeros((len(adjM),len(adjM)))
    # performing trials until specified number is reached
    for i in range(numTrials):
        # defining current random var and summation value for current trial
        randomNum = rand.uniform(0,1)
        summation = 0
        curK = 0
        curJ = 0
        # Looping through matrix to add to summation
        for k in range(len(adjM)):
            for j in range(len(adjM)):
                summation += trPM[k][j]
                if(summation >= randomNum):
                    curJ = j
                    break
            if(summation >= randomNum):
                curK = k
                break
        pageMatrix[curK][curJ] += 1
        # Initializing resultant array
        resultMatrix = np.zeros((len(adjM),1))
        for i in range(len(adjM)):
            resultMatrix[i][0] = pageMatrix[0][i]/numTrials
    return resultMatrix


crawlM = crawl(adjM, degM, trPM, numTrials)
print("Ranks: \n", crawlM)


plt.hist(crawlM, len(crawlM))
plt.xlabel("Ranks")
plt.ylabel("Appearance Amount")
plt.show()
