# Stephen Terrio, B00755443, CSCI 2202 - Lab 7
# Revisiting trajectory with numpy

# Packages
import math
import numpy as np
import matplotlib.pyplot as plt

# Defining Values -
timeInt = 0.05 # Time Interval

# Taking user input for the specified Velocity and Angle Values...
velocityInit = int(input("Enter the initial velocity: "))
angle = int(input("Enter the firing angle in degrees: "))

# Initiallizing the other variables.
maxTime = round(2*(velocityInit/9.81)) * 1.25 # estimated maximum Time, using *1.5 as buffer
nIntervals = math.ceil(maxTime/timeInt) # The estimated amount of intervals
time = 0 # Using to store current times in time array
aX = 0 # acceleration for x
aY = -9.81 # acceleration for y

# - Starting positions of X and Y co-ordinates -
x = -200
y = 0
# - Starting velocities -
velocityX = velocityInit
velocityY = velocityInit

# Initiallizing The three Numpy Arrays (X, Y & T) - And the two numpy Arrays (vX, vY)-
xPos = np.array([x])
yPos = np.array([y])
timeVals = np.array([time])
velX = np.array([velocityX])
velY = np.array([velocityY])

# Through the time, retrieve those values and their change and append to respective arrays.
for i in range(0,nIntervals,1):
    #Velocity X -
    velocityX = velocityX + aX*timeInt
    velX = np.append(velX, velocityX)
    #Velocity Y -
    velocityY = velocityY + aY*timeInt
    velY = np.append(velY, velocityY)
    # X positions -
    x += velocityX*timeInt + 0.5*aX*(timeInt**2)
    xPos = np.append(xPos,x)
    #Y positions -
    y += velocityY*timeInt + 0.5*aY*(timeInt**2)
    print(y)
    yPos = np.append(yPos, y)
    #Time -
    time += 0.02
    timeVals = np.append(timeVals, time)

# Finding the Max height and the Time it Occurs -
yMax = 0
index = 0
for i in range(0,nIntervals,1):
    if yPos[i] > yMax :
        yMax = yPos[i]
        index = i
timeMaxHeight = timeVals[index]

# Finding the Max range and the Time it Occurs -
xMax = 0
index = 1
for i in range(0,nIntervals,1):
    if yPos[i] > 0 :
        xMax = xPos[i]
        index = i
timeMaxRange = timeVals[index]

for i in range(0, nIntervals, 1):
    print("Time = %6.3f  X position = %6.3f   Y position = %6.3f" %(timeVals[i], xPos[i], yPos[i]))
