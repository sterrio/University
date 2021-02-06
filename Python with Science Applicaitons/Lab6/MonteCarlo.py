# Stephen Terrio, B00755443, CSCI 2202 - Lab 6
# Utilizing the Random library to compute dart impacts when thrown.

# Packages
import math
import random
import numpy as np

def PI(darts):
    # Used to keep track of all dart throw attempts
	points=darts
    # Used to keep track of darts inside the circle Quadrant
	verifiedPoints=0
	# running the simulation for numThrows times using for loop
	for i in range(darts):
		xThrow=random.uniform(0,1) # Our random X throw (between 0, 1)
		yThrow=random.uniform(0,1) # Our Random Y throw (between 0, 1)
	       # Finding distance from impact to center. Math.hypt ->sqrt(x^2 + y^2)
		distance=math.hypot(xThrow, yThrow)
		# if this dart falls within the correct quadrant, increment verifiedPoints to keep track
		if(distance<1):
			verifiedPoints+=1
    # Given Formula, 4 x Num darts in the Quadrant/ Total Num. darts thrown
	return verifiedPoints*4/points;


# Printing out Table
for i in range(1,5): # 10 -> 10,000
    # Increment by a factor of 10 until throw limit reaches 10000
    attempts = 10**i
    estimation = PI(attempts)
    error = (estimation - math.pi)/math.pi

    # Handling both Positive and Negative cases.
    if(error<0):
        print("Number of Trials = %-8d   Estimated = %f   Error = %.6f" %(attempts,estimation,error))
    else:
    	print("Number of Trials = %-8d   Estimated = %f   Error = %+.6f" %(attempts,estimation,error))

## PART II - NUMPY
# init variables for the np.array of counts
countInLocOne = 0
countInLocTwo = 0
countInLocThree = 0
countInLocFour = 0
countInLocFive = 0
countInLocSix = 0

for i in range(0,10000):
    estimation = PI(1000)
    if  estimation < 3.1:
        countInLocOne+=1
    elif estimation >= 3.1 and estimation < 3.12:
        countInLocTwo+=1
    elif estimation >= 3.12 and estimation < 3.14:
        countInLocThree+=1
    elif estimation >= 3.14 and estimation < 3.16:
        countInLocFour+=1
    elif estimation >= 3.16 and estimation < 3.18:
        countInLocFive+=1
    elif estimation >= 3.18:
        countInLocSix+=1

print("\nThe numpy count values are: ")
countArray = np.array([countInLocOne,countInLocTwo,countInLocThree,countInLocFour,countInLocFive,countInLocSix])
print(countArray)
