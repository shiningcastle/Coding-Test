# 내장함수 없이 구현
import sys
inp = sys.stdin.readline

n = int(inp())
lis = list(map(int, inp().split()))
ans = [lis[0]] * 2

for i in range(n):
  if lis[i] < ans[0]:
    ans[0] = lis[i]
  elif lis[i] > ans[1]:
    ans[1] = lis[i]

for a in ans:
  print(a, end = ' ')

# 내장함수로 짧게 구현
import sys
inp = sys.stdin.readline

n = int(inp())
lis = list(map(int, inp().split()))

print(str(min(lis)) + " " + str(max(lis)))