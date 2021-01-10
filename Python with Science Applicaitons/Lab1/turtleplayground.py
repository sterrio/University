# Stephen Terrio, B00755443 - CSCI 2202
import turtle

# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("TurtleSquare")

mickey = turtle.Turtle()

# Q. What happens when you remove the Turtle shape property?
# A - We can see that the leading (pen) side of where the drawing is made changes from a turtle to an arrow.

mickey.pencolor("blue")
mickey.fd(100)
mickey.fd(100)
mickey.fd(90)
mickey.right(90)
mickey.fd(100)
mickey.right(90)
mickey.fd(100)
mickey.fd(100)
mickey.fd(100)
