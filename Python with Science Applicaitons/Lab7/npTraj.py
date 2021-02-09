# Stephen Terrio, B00755443, CSCI 2202 - Lab 7
# Revisiting trajectory with numpy

# Packages
import math
import turtle
import numpy as np
import matplotlib.pyplot as plt

# Defining Values -
timeInt = 0.02 # Time Interval

# Taking user input for the specified Velocity and Angle Values...
velocityInit = int(input("Enter the initial velocity: "))
angle = int(input("Enter the firing angle in degrees: "))

# Initiallizing the other variables.
maxTime = round(2*(velocityInit/-9.81))
nIntervals = maxTime/timeInt
time = 0
aX = 0
aY = -9.81
# - Starting positions of X and Y co-ordinates -
x = -200
y = 0
# - Starting velocities -
velocityX = velocityInit
velocityY = velocityInit

# Initiallizing The three Numpy Arrays (X, Y & T) - And the two numpy Arrays (vX, vY)-



# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("Launch")
launch = turtle.Turtle()

# Setting launch location
launch.penup()
launch.goto(-200,0)
launch.pendown()
launch.rt(-angle)

# Using exit on click to view a preview of the shape before auto-closing.
turtle.exitonclick()
