# Stephen Terrio, B00755443 - CSCI 2202 Lab 3
# Creating a program that takes in input of rows and prints out the corresponding amount of '*'s in triangular fashion

# Getting User Input for number of Rows
numRows = int(input("Enter the number of Rows: "))

# Looping through all rows to determine where to drop lines (excluding the first)
for x in range(numRows):
    if x > 0:
        print()
        # using which row we are on (x) we determine how many stars to print. (x+1 to account for 0 indexing)
    for y in range(x+1) :
        print("*", end='')

# Final print to ensure shell displays proper output. (May not be needed on some machines)
print()
