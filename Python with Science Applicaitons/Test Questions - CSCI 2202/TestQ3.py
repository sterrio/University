# Stephen Terrio

#packages
import random

countSingle = 0
countDouble = 0
tests = 100000

# Finding Likeliness of a single 6
for i in range(tests):
    for i in range(6):
        roll = random.randrange(1,7,1)
        if roll == 6 :
            countSingle = countSingle + 1
            break

singleChance = countSingle/tests
print("The Chance of a single six appearing in 6 rolls is: ", singleChance, "After 100,000 trials")

# Finding Likeliness of a two 6's
for i in range(tests):
    count = 0
    for i in range(12):
        roll = random.randrange(1,7,1)
        if roll == 6 :
            count = count + 1
        if count == 2 :
            countDouble = countDouble + 1
            break

doubleChance = countDouble/tests
print("The Chance of a two six's appearing in 12 rolls is: ", doubleChance, "After 100,000 trials")

# Looking at the results, it is generally more likely for a single six to appear in 6 rolls, than it is for 12 six's to appear in 12 rolls
