# Stephen Terrio, B00755443 - CSCI 2202 Lab 3
# Creating a trajectory calculator using turtle display

#Packages
import math

#Input (fixed)
velocity = 70

# Increasing the angle by 5 degrees each step, until 80
for x in range(20,80,5):
    print()
    print("CURRENT ANGLE: ", x)
    angle = x

    # Calculating firing angle
    corAngle = ((angle)*math.pi/180)

    #creating lists to hold values
    xvals = [None] * 15
    yvals = [None] * 15
    timevals = [None] * 15

    #calculating the trajectory based on estimated time T with steps
    for i in range(0,15,1):
        newx = (-200+velocity*math.cos(corAngle)*i)
        newy = (0+(velocity*math.sin(corAngle)*i)-(0.5*(9.81)*i**2))

        # Saving each value for later to be outputted side by side
        xvals[i] = newx
        yvals[i] = newy
        timevals[i] = i

    negativeY = yvals[0]
    # Finding when y val becomes negative
    for i in range(1,15):
        if yvals[i] <= 0 :
            negativeY = i
            break

    # calculating max distance estimate
    maxX = (-200+velocity*math.cos(corAngle)*negativeY)
    print("The estimated max x distance value is: ", maxX)

    # Initiating new time variable for max Height
    timeY = 0

    # Finding when vy becomes negative
    for i in range(1,15):
        velY = velocity*math.sin(corAngle)-(9.81*i)
        if velY < 0 :
            timeY = i
            break

    # Using timeY to find the max height
    maxHeight = (0+(velocity*math.sin(corAngle)*timeY)-(0.5*(9.81)*timeY**2))
    print("The estimated max height reached is: ", maxHeight)
