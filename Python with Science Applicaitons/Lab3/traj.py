# Stephen Terrio, B00755443 - CSCI 2202 Lab 3
# Creating a trajectory calculator using turtle display

#Packages
import turtle
import math

#Inputs
angle = int(input("Enter the firing angle in degrees: "))
velocity = int(input("Enter the velocity: "))

# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("Launch")

# Setting launch location
launch = turtle.Turtle()
launch.penup()
launch.goto(-200,0)
launch.pendown()

# Calculating firing angle
corAngle = ((angle)*math.pi/180)
launch.rt(corAngle)

#creating lists to hold values
xvals = [None] * 15
yvals = [None] * 15
timevals = [None] * 15

#calculating the trajectory based on estimated time T with steps
for i in range(0,15,1):
    newx = (-200+velocity*math.cos(corAngle)*i)
    newy = (0+(velocity*math.sin(corAngle)*i)-(0.5*(9.81)*i**2))
    #Traversing and stamping
    launch.goto(newx,newy)
    launch.stamp()

    # Saving each value for later to be outputted side by side
    xvals[i] = newx
    yvals[i] = newy
    timevals[i] = i

# Printing the table of values
print("The following is a table of all outputs, X Y Time")
# printing the table of x y values with time icluded.
for i in range(0,15,1):
    print (xvals[i], " ", yvals[i], " ", i)
print()

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

# Using exit on click to view a preview of the shape before auto-closing.
turtle.exitonclick()
