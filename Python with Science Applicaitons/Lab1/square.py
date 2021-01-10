# Stephen Terrio, B00755443 - CSCI 2202
import turtle

# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("TurtleSquare")

mickey = turtle.Turtle()

# This will be the "formula" for each side to create a square.
mickey.pencolor("blue")
mickey.fd(100)
mickey.right(90)

mickey.pencolor("red")
mickey.fd(100)
mickey.right(90)
mickey.pencolor("green")
mickey.fd(100)
mickey.right(90)
mickey.pencolor("pink")
mickey.fd(100)
# Note: No final rotation required as the shape is complete.
