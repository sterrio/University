# Stephen Terrio, B00755443 - CSCI 2202 Lab 2
# Creating a polygon with a custom number of sides via user Input

import turtle

# Getting User Input for number of sides in the polygon
numSides = int(input("Enter the number of Sides: "))

# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("TurtleSquare")

mickey = turtle.Turtle()
ROT = 360/numSides

# Accounting for the " x " sides, we can use a for loop similar to Ex. 3
for i in range(numSides):
    # 360/numSides = our rotation, therefore we will rotate ROT degrees at each turn for a perfect polygon
    mickey.rt(ROT)
    # This scaling will ensure that all polygons fit within the the turtle window.
    mickey.fd(400/numSides)

# Using exit on click to view a preview of the shape before auto-closing.
turtle.exitonclick()
