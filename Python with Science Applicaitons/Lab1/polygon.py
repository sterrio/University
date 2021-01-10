# Stephen Terrio, B00755443 - CSCI 2202
import turtle

# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("TurtleSquare")

mickey = turtle.Turtle()

# Accounting for the 6 sides, we can use a for loop similar to Ex. 3
for i in range(6):
    # 360/6 = 60, therefore we will rotate 60 degrees at each turn for a perfect polygon
    mickey.rt(60)
    mickey.fd(100)
