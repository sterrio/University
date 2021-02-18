# Stephen Terrio, B00755443, CSCI 2202 - Lab 5
# Initial creation of draw functions to eventually create a flower

# Packages
import math
import turtle

def polyLine(t,n,length,angle):
    # Draws 'n' line segments of length 'length'; tilted at angle 'angle'
    for i in range(n):
        t.fd(length)
        # Not entirely sure why, but my 'angle' needs to be negative here to replicated the example shown, otherwise the image is inversed
        t.rt(-angle)

def polygon(t, numSides):
    #Completes a full polygon using the polyLine function
    tempAngle = 360/numSides
    polyLine(t, numSides, 100, tempAngle)

def drawArc(t, radius, degrees):
    #Drawing an arc length based on radius and angle
    radians = degrees * (math.pi/180)
    # converted agnle to radians
    s = int(radius*radians)
    length = math.ceil((s/5))
    #Finding line length
    polyLine(t,length,5,degrees/length)

# Simply using drawArc, but for an entire 360 degree radius
def drawCircle(t, radius):
    drawArc(t,radius,360)

# Drawing petals via the arc function, inversing in between
def drawPetal(t, radius):
    t.color("pink")
    drawArc(t, radius, 60)
    t.rt(270)
    drawArc(t,radius,60)

# Drawing a line as a stem with a set heading and length
def drawStem(t, length, heading):
    t.color("brown")
    t.rt(360-heading)
    t.fd(length)

# Incorporating all functions to draw a flower
def drawFlower(t, radius, angle, numPetals, p):
    # drawing the flower stem
    drawStem(t, radius, angle)
    # Using temporary rotation to distribute petals evenly
    tempRot = 0
    # Loop and draw "numPetals" times, adding p to the rotation agnle each time
    for i in range(numPetals):
        t.setheading(90+tempRot)
        t.rt(p)
        drawPetal(t, radius)
        tempRot = tempRot + p

# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("Launch")
t = turtle.Turtle()

drawArc(t, 100, 90)
# Using exit on click to view a preview of the shape before auto-closing.
turtle.exitonclick()
