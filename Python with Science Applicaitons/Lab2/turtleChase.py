# Stephen Terrio, B00755443 - CSCI 2202 Lab 2
# Creating a "chase" program for a blue turtle to catch up to the red one, and display it's path.


import turtle

# Getting User Input for number of sides in the polygon
distance = int(input("Enter the Distance travelled by Red: "))

# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("TurtleSquare")

# Initiating the two different turtles
red = turtle.Turtle()
blue = turtle.Turtle()

red.color("red")
red.penup()
red.setx(-distance/2)
red.pendown()

blue.color("blue")
blue.penup()
blue.sety(distance/2)
blue.pendown()

red.fd(distance)
blue.goto(red.position())

# Using exit on click to view a preview of the shape before auto-closing.
turtle.exitonclick()
