#Stephen Terrio, B00755443
# Assignmenet 1 - Polygon Rotator

# Packages
import math
import turtle

# Imported Functions from lab - draw.py (Drawing flowers)
def polyLine(t,n,length,angle):
    # Draws 'n' line segments of length 'length'; tilted at angle 'angle'
    for i in range(n):
        t.fd(length)
        t.rt(-angle)

def polygon(t, numSides):
    #Completes a full polygon using the polyLine function
    tempAngle = 360/numSides
    polyLine(t, numSides, 100, tempAngle)

# Code -
# Taking user input for the specified Side Amount & Rotational Degree...
sideCount = int(input("Enter the polygon Side Count: "))
rotateCount = int(input("Enter the number of polygon: "))

# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("Launch")
t = turtle.Turtle()

#This ensures even distribution and tracks how many rotations have occured already
tempRot = 0
roDegree = int(360/rotateCount)

# Looping through the correct amount of rotations..
for i in range(0,rotateCount,1):
    # If even, set color to blue, if uneven, red
    if i%2 == 0:
        t.color("blue")
    else: t.color("red")
    # Rotate the correct amount from origin (90) and draw the polygon using the function
    t.setheading(90+tempRot)
    t.rt(roDegree)
    polygon(t,sideCount)
    tempRot += roDegree

# Using exit on click to view a preview of the shape before auto-closing.
turtle.exitonclick()
