import sys
inp = sys.stdin.readline

m = 0
while (True):
  l, p, v = map(int,inp().split())

  if ((l, p, v) == (0, 0, 0)):
    break
    
  answer = 0
  m += 1

  a1 = (v // p) * p
  a2 = ( l * (v // p) )

  answer += a2
  
  # V를 P로 나누었을 때 딱 나누어 떨어지지 않는 경우에 추가
  if (v / p) > (v // p) : 
    if (v - a1) > l:
      answer += l
    else:
      answer += (v - a1)
     
  print("Case " + str(m) + ": " + str(answer))