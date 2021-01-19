# Stephen Terrio, B00755443 - CSCI 2202 Lab 3
# Creating a program that takes in input of rows and columns and prints out the corresponding amount of '*'s

# Getting User Input for number of Rows and Columns
numRows = int(input("Enter the number of Rows: "))
numCol = int(input("Enter the number of Columns: "))

# Looping through all rows to determine where to drop lines (excluding the first)
for x in range(numRows):
    if x > 0:
        print()
        # Looping through all columns and ensuring there is a *.
    for y in range(numCol) :
        print("*", end='')

# Final print to ensure shell displays proper output. (May not be needed on some machines)
print()
