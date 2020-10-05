# Stephen Terrio, B00755443, CSCI 2201 Lab 3

password = input("Enter the 4 character pass: ")

# Importing datetime library
from datetime import datetime
now = datetime.now()

# Password cracking
# Creating Strings to hold information
alpha = ("abcdefghijklmnopqrstuvwxyz")
alphaCaps = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
symbols = ("1234567890!@#$%^&*()")
concatStr = alpha

# Checking which strings to combine via what the input uses
if (any(char.isupper() for char in password)):
    concatStr = alpha + alphaCaps

if (any(not char.isalnum() for char in password) or (any(char.isdigit() for char in password))):
    concatStr = alpha + alphaCaps + symbols

# Turning the string into an array of all possible characters
keyArray = list(concatStr)
solved = ""
counter = 0

for i in range(len(keyArray)):
    if(solved == password): break
    for n in range(len(keyArray)):
        if(solved == password): break
        for m in range(len(keyArray)):
            if(solved == password): break
            for z in range(len(keyArray)):
                counter+=1
                solved = keyArray[i] + keyArray[n] + keyArray[m] + keyArray[z]
                if(solved == password): break

print(solved)
print(counter)
# Getting time post program completion
later = datetime.now()
diff = (later - now).total_seconds()

# Time Output
print(diff)
