import sys
inp = sys.stdin.readline

n, l, k = map(int, inp().split())
# 점수
answer = 0
# 문제 난이도 리스트
ques = []

for i in range(n):
    sub1, sub2 = map(int, inp().split())
    ques.append( [sub1, sub2] )

# 어려운 버전을 풀 수 있으면 획득 가능 점수 140
# 쉬운 버전만 풀 수 있으 획득 가능 점수 100
# 둘 다 못 풀면 획득 가능 점수 0점
for i in range(len(ques)):
    if ques[i][1] <= l:
        ques[i] = 140
    elif ques[i][0] <= l:
        ques[i] = 100
    else:
        ques[i] = 0

# 점수 높은 것 부터 풀기위해 정렬
ques.sort(reverse = True)

# k개 만큼 풀 수 있는 것중에 배점 높은 순으로 문제 풀기
# 풀 수 있는 문제 수와 최대 풀이 가능 문제 수가 서로 적거나 많을 수 있는 경우 고려
for q in ques:
    if k > 0:
        answer += q
        k -= 1

print(answer)