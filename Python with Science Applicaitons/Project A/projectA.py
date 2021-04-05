# Stephen Terrio, B00755443
# Project A - Page Rank Simulation:

# Packages -
import numpy as np
import math

# Change this to the corresponding file name  -
file = 'tiny.txt'

# Taking defining file input function
def adjMatrixFromFile(filename):
    # Reading file and getting the size of matrix [N]x[N]
    dataXY = open(filename,'r')
    lines = dataXY.readlines()
    matrixN = int(lines[0][0])
    nodeMatrix = []
    # Using that size to init the Adj Matrix
    adjArray = np.zeros((matrixN, matrixN))
    # We now have a string array of inputs, looping through each line for adj calcs
    for line in lines:
        currentLine = line.strip()
        index = currentLine.split(" ")
        # Accounting for first line of N declaration
        if(len(line) > 4):
            # Loop through each value in lines
            for i in range(len(line)):
                # If it contains a adjacency value, add to matrix, else skip
                if(line[i] == ' ' or line[i] == '\n'):
                     i += 1
                else:
                    # Appending to a new node list
                    node = int(line[i])
                    nodeMatrix.append(node)
    # Looping through node list and adding nodes to adj Matrix
    for i in range(0, len(nodeMatrix), 2):
        adjArray[nodeMatrix[i]][nodeMatrix[i+1]] += 1
    # Closing file and returning adjacency matrix
    dataXY.close()
    return adjArray

# Defining Out Dgrees Function
def outDegrees(adjacencyMatrix):
    # Retrieving Length
    length = len(adjacencyMatrix)
    # Filling new np array to store summation
    degreeArray = np.zeros((length,1))
    # Looping through each element of each row, summing and saving to degree matrix
    for i in range(length):
        for j in range(length):
            degreeArray[i][0] += adjacencyMatrix[i][j]
    # retrun degree matrix
    return degreeArray

# Defining probabilities function
def transitionProbabilities(adjacencyMatrix, outDegrees):
    # Retrieving Length
    length = len(adjacencyMatrix)
    # Filling new np array to store summation
    transtionMatrix = np.zeros((length,length))
    # Looping through each element of each row, calculate transition probabilities
    for i in range(length):
        for j in range(length):
            transtionMatrix[i][j] += 0.90 * (adjacencyMatrix[i][j]/outDegrees[i][0]) + (0.10/length)
    # retrun degree matrix
    return transtionMatrix

# Function Calls -
adjM = adjMatrixFromFile(file)
degM = outDegrees(adjM)
print("Adjacency Matrix: \n", adjM)
print("\n Out degrees: \n", degM)

trPM = transitionProbabilities(adjM, degM)
print("\n Transition Matrix: \n", trPM)
