## Stephen Terrio

# getting input
dna = input("Please enter the DNA sequence: ")

# Changing to uppercase
str(dna)
dna = dna.upper()

# Looping through the string and getting the counts of each letter
count = len(dna)
countA = 0
countC = 0
countG = 0
countT = 0
for i in range(count):
    if(dna[i] == "A"):
        countA = countA+1
    elif(dna[i] == "C"):
        countC = countC+1
    elif(dna[i] == "G"):
        countG = countG+1
    elif(dna[i] == "T"):
        countT = countT+1

print("The frequency of the bases is A:",countA,"C:",countC,"G:",countG,"T:",countT)
