# Stephen Terrio, B00755443, CSCI 2201 Lab 4

from datetime import datetime
# Getting User inputted password.
password = input("Enter your password: ")

# Reading & saving the txt. file that contains the common passwords
passwords = "commonpasswords.txt"
with open(passwords) as f:
    keyArray = [line.rstrip("\n") for line in open(passwords)]

# Starting password crack
now = datetime.now()
solved = ""
counter = 0

for i in range(len(keyArray)):
    counter+= 1
    solved = keyArray[i]
    if (solved == password): break;

#finalizing timer.
current = datetime.now()
time = (datetime.now() - current).microseconds
# Handling both found and not found cases for ouput.
print("Crack took",time,"microseconds");
if(solved == password):
    print("Case was successful, password:",solved,"- was found after",counter,"tries")
else:
    print("Case was unsuccessful, password:",password,"- was not found after",counter,"tries")
