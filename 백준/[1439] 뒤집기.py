import sys
inp = sys.stdin.readline

ex = inp().strip()
count = 0

for i in range(1, len(ex)):
  if ex[i-1] != ex[i]:
    count += 1

print( (count + 1) // 2 )