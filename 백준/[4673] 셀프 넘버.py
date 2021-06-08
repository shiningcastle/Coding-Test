answer = [True for i in range(1, 10001)]
for n in range(1, 10001):
  oneList = [int(x) for x in str(n)]
  ssum = n + sum(oneList)
  if ssum <= 10000:
    answer[ssum - 1] = False

for i in range(len(answer)):
  if answer[i] == True:
    print(i+1)