import sys
inp = sys.stdin.readline

n, l = map(int, inp().strip().split())
height = list(map(int, inp().strip().split()))
height.sort()

for i in range(len(height)):
  if l >= height[i]:
    l += 1
  else:
    break
    
print(l)