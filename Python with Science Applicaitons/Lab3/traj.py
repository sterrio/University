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

#calculating the trajectory based on estimated time T with steps
for i in range(0,15,1):
    newx = (-200+velocity*math.cos(corAngle)*i)
    newy = (0+(velocity*math.sin(corAngle)*i)-(0.5*(9.81)*i**2))
    #Traversing and stamping
    launch.goto(newx,newy)
    launch.stamp()

# Using exit on click to view a preview of the shape before auto-closing.
turtle.exitonclick()
