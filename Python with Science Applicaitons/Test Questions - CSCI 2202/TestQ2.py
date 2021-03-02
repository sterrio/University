# Stephen Terrio

#packages
import numpy as np

# getting input
n = int(input("Please enter the number: "))
initn = n

# creating a list to store values
arr = np.array([])

count = 0
while(n != 1 and n != 0):
    if(n % 2 ==0):
        arr = np.append(arr, n)
        count = count + 1
        n = int(n/2)
    else:
        arr = np.append(arr, n)
        count = count + 1
        n = int(n*3 + 1)

arr = np.append(arr, n)
count = count + 1
print("The sequence for",initn,"has length",count)
print("It is:", arr)
