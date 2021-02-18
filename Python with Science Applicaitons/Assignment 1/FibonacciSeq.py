#Stephen Terrio, B00755443
# Assignmenet 1 - Fibonacci Sequence

# Packages
import math
import turtle

## PART I --

# Taking in user input for N fib-terms
n = int(input("Input the N number of terms: "))
j = int(input("Input the J number for Golden Ratio: "))

# Fib sequence 1 & 2
fib1 = 0
fib2 = 1
# Creating array to store fib values
F = []

# Loop through until count reaches input number of terms
count = 0
while count < n:
    # fill array
    F.append(fib1)
    # update values, increment count
    currentTerm = fib1 + fib2
    fib1 = fib2
    fib2 = currentTerm
    count += 1

for i in range(len(F)):
    if i%5 == 0 and i != 0:
        print("\n")
        print('{:5d}'.format(F[i]), end="")
    else:
        print('{:5d}'.format(F[i]), end="")
print("\n")

# At the end of the year, there would be 144 rabbits (to answer the problem), this is because it is the 12th index in it's monthly growth rate, excluding 0

## PART 2 --- GOLDEN RATIO
if j <= 20 and j >= 2:
    gR = F[j+1]/F[j]
    print("The Golden Ratio for J is ", gR)
else:
    print("J value is invalid for given Fib sequence N length")

## PART 3 --- FIBONACCI SPIRAL

# Inporting functions from Draw.py
def polyLine(t,n,length,angle):
    # Draws 'n' line segments of length 'length'; tilted at angle 'angle'
    for i in range(n):
        t.fd(length)
        # Not entirely sure why, but my 'angle' needs to be negative here to replicated the example shown, otherwise the image is inversed
        t.rt(-angle)

def drawArc(t, radius, degrees):
    #Drawing an arc length based on radius and angle
    radians = degrees * (math.pi/180)
    # converted agnle to radians
    s = int(radius*radians)
    length = math.ceil((s/5))
    #Finding line length
    polyLine(t,length,5,degrees/length)

# New function to draw a quarter circle based on different Spiral elements
def drawSpiral(t, fib):
    drawArc(t,fib,90)

# Creating a new window instance
turtleWindow = turtle.Screen()
turtleWindow.title("Launch")
t = turtle.Turtle()

for i in range(10):
    if i%3 == 0 and i != 0:
        t.color("yellow")
    elif i%2 == 0 and i != 0:
        t.color("blue")
    elif i == 0:
        t.color("green")
    else:
        t.color("red")
    temp = F[i+1]
    drawSpiral(t, temp *5)

# Using exit on click to view a preview of the shape before auto-closing.
turtle.exitonclick()
