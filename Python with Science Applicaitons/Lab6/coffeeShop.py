# Stephen Terrio, B00755443, CSCI 2202 - Lab 6
# Utilizing the Random library to create a coffee shop meeting script

# Packages
import math
import random

def coffee(meetings):
    # How many times they try to meet
    attemptedVists = meetings
    # Tracking meet %
    missed = 0;
    met = 0;

    for i in range(attemptedVists):
        # Rolling at which time they arrive
        mollieTime = round(random.uniform(0,30))
        chloeTime = round(random.uniform(0,30))

        # Mollie Arrives first
        if mollieTime < chloeTime:
            diff = chloeTime - mollieTime
            closing = mollieTime + (30 - mollieTime)

            # if Close deosn't arrive before closing
            if chloeTime >= closing:
                missed+=1
            # otherwise...
            elif diff <= 5:
                met+=1
            else: missed+=1

        # Chloe Arrives first
        elif chloeTime < mollieTime:
            diff = mollieTime - chloeTime
            closing = 30 - chloeTime

            # If Mollie doesn't arrive before closing
            if mollieTime >= closing:
                missed+=1
            elif diff <= 7:
                met+=1
            else: missed+=1

    print("Meetings Occured:", met)
    print("Meetings Missed:", missed)

coffee(10000)

# All answers based on a data-set of 10,000 meeting attempts -

#Q1. The Ratio normally avergaes around 2700:7300, therefore, the average % meetings succed is 0.27, or 27% chance to meet
#Q2. If Chloe drops her time to the same as Mollies, the ratio drops to 2200:7800, meaning the new average is 0.22 or 22% chance to meet
#Q3. If Mollie Raises her waiting time, the ratio becomes 3000:7000, meaning the new average is 0.30 or 30% chance to meet
