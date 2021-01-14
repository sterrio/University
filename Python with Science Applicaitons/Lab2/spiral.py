# Stephen Terrio, B00755443 - CSCI 2202 Lab 2
# Creating a spiraling polygon that terminates once side length reaches 200.

# The main difference here will be that we have to loop through a dynamically changing side length.

import turtle

# Getting User Input for number of sides in the polygon
numSides = int(input("Enter the number of Sides: "))

# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("TurtleSquare")

mickey = turtle.Turtle()
ROT = 360/numSides

# Initiating a new Int to store our current side length.
sideLength = 5

# Accounting for the end condition of side length, we can use a while loop.
while sideLength < 200:
    # 360/numSides = our rotation, therefore we will rotate ROT degrees at each turn for a perfect polygon
    mickey.rt(ROT)
    # This scaling will ensure that the spiral progressively approaches 200.
    mickey.fd(sideLength)
    sideLength += 2

# Using exit on click to view a preview of the shape before auto-closing.
turtle.exitonclick()
