# Stephen Terrio, B00755443 - CSCI 2202 Lab 4
# Taking in a year and determining if it is a leap year or not

#Packages
import math

#Input
year = int(input("Enter the year: "))

# Handling the case that the year is past century requirement and valid leap
if year > 1582 and year%100 != 0 and year%4 == 0:
    print(year, "is a leap year")
    quit()
    # handling the centurie numbers (1900/2000/2100.. etc)
elif year%100 == 0 and year%400 == 0:
    print(year, "is a leap year")
    quit()
else:
    # if not found, not applicable year.
    print(year, "is not a leap year")
