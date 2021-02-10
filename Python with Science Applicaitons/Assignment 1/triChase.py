#Stephen Terrio, B00755443
# Assignmenet 1 - Turtle Triangle Chase

# Packages
import math
import turtle

# Equilateral triangle with side length 400
triSide = 400

# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("TurtleSquare")

# Initiating the two different turtles
red = turtle.Turtle()
blue = turtle.Turtle()
green = turtle.Turtle()

#Initilizing the three turtles for chase sequence
red.color("red")
red.penup()
red.sety(triSide-200)
red.pendown()

blue.color("blue")
blue.penup()
blue.sety(-200)
blue.setx(-triSide/2)
blue.pendown()

green.color("green")
green.penup()
green.sety(-200)
green.setx(triSide/2)
green.pendown()

# While the positions aren't equal, set headings to destination turtles and increment one step forward
while green.position()!= red.position() and green.position()!= blue.position():
    red.setheading(red.towards(green))
    red.fd(1)
    blue.setheading(blue.towards(red))
    blue.fd(1)
    green.setheading(green.towards(blue))
    green.fd(1)
    if (green.heading() == blue.heading() or green.heading() == blue.heading() -1 or green.heading() == blue.heading() - 2):
        break

# Using exit on click to view a preview before auto-closing.
turtle.exitonclick()
