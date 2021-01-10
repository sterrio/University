# Stephen Terrio, B00755443 - CSCI 2202
import turtle

# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("TurtlePicasso")

mickey = turtle.Turtle(shape="turtle")

# Incorporating for loops using range to write more efficiently.

for i in range(3):
    mickey.fd(100)

for i in range(6):
    mickey.bk(90)

mickey.rt(20)
mickey.lt(20)
mickey.penup()
mickey.pendown()
mickey.goto(200,0)
