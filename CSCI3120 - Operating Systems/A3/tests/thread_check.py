#!/usr/bin/python3

import sys

thread = False
loc = 0

for line in sys.stdin.readlines():
  inp = line.split()
  loc = loc + 1

  if inp[0] == 'Block':
    nonces = [0] * 100
    prev = 0
    in_order = True
    num = 0
    thread = False
  elif inp[0] == 'Thread':
    thread = True
    t = int(inp[1])
    n = int(inp[4],16)
    if nonces[t] != 0:
      diff = n - nonces[t]
      if num == 0:
        num = diff
      elif diff != num:
        print("Oops: Nonces out of sequence in thread {}".format(t))
        print("Differences between nonces is not consistent")
        print("Error detected on line {} of your output".format(loc))
        exit(1)
    nonces[t] = n
    if prev > n:
      in_order = False
    prev = n
  elif thread:
    thread = False
    nonce = int(inp[0], 16)
    t = nonce % num
    if nonces[t] != nonce:
      print("Oops: Computed nonce should be {} by thread {}".format(nonce, t))
      print("Error detected on line {} of your output".format(loc))
      exit(1)
    elif in_order:
      print("Oops: All computed nonces are in complete order.")
      print("This is highly unlikely")
      print("Error detected on line {} of your output".format(loc))
      exit(1)

exit(0)
