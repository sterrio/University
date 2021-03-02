# Stephen Terrio

# Packages
import numpy as np

date = input("Enter a date (DD-MM-YYYY): ")
days = 0

# handling months
months = np.array([31, 28, 31, 30, 31, 30, 31,31,30,31,30,31])

# Finding days by using tens for the first digit, and singles for the second
tens = int(date[0])
if(tens == 1):
    days = days + 10
elif(tens == 2):
    days = days + 20
elif(tens == 3):
    days = days + 30
singles = int(date[1])
days = days + singles

# Finding months using same methodology
tensMonth = int(date[3])
month = 0
if(tensMonth == 1):
    month = month + 10

singleMonth = int(date[4])
month = month + singleMonth

daysPast = 0
# Looping through the array the amount of months times, adding each value until current month is found
for i in range(month - 1):
    daysPast = daysPast + months[i]

totalTime = days + daysPast
print(date, "is day:",totalTime)
