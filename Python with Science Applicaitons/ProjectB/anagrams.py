# Stephen Terrio, B00755443
# Project B - Recursive Anagrams:

# Packages -
import time
import math

# Change this to the corresponding file name  -
filename = 'small_words_6.txt'

# Reading file and setting up a list of potential words
lexicon = open(filename,'r')
lines = lexicon.readlines()
words = []
for line in lines:
    currentLine = line.strip()
    words.append(currentLine)

# Getting User Input for word that will be used as base line
bWord = input("Enter the word to use: ")
bWord = bWord.lower()

# Defining the search function to be used in the anagram function -
def search(lexicon, candidate):
    # Have to append new line to match words in wordlexicon
    if (candidate + "\n" in lexicon):
        return True
    else:
        return False

# Defining Anagram Function -
def anagram(lexicon, letters, prefix):
    # print(f"Calling anagram with letters: {letters} prefix: {prefix}\n")
    solutions = []
    letters = list(letters)
    # Base case
    if (len(letters) == 1):
        prefix += letters[0]
        # Check to see if solution found
        if (search(lexicon, prefix)):
            return [prefix]

    #  Recursive step -
    for letter in letters:
        newPrefix = prefix + letter
        newLetters = letters.copy()
        newLetters.remove(letter)
        solution = anagram(lexicon, newLetters, newPrefix)
        if (solution):
            solutions = solutions + solution
    return solutions

# Start a Timer before running any functions -
start = time.time()
solutions = anagram(lines, bWord, '')
print("The solutions list contains..\n", solutions)

# Writing Solutions List to file -
with open('anagramsOut.txt', 'w') as f:
    for word in solutions:
        f.write("%s\n" % word)

# Stopping timer and getting overall runningTime -
stop = time.time()
lexicon.close()
runningTime = stop - start
print("This was found in: ", runningTime, " seconds")

# The running time for "petals" is - 0.08485603332519531  seconds
# The running time for "crate" is -  0.009353160858154297 seconds
