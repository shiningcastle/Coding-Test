def solution(S):
    dic = {"[" : "]", "{" : "}", "(" : ")"}
    lis = []
    
    for s in S:
        if s in "]})":
            # 처음부터 닫는 괄호 나오는 경우의 수 막아주기
            if len(lis) == 0:
                return 0
            if lis.pop() != s:
                return 0
        else:
            lis.append(dic[s])
	# 열기만 하고 닫지 않은 괄호 존재 시 0 반
    if len(lis) != 0:
        return 0

    return 1