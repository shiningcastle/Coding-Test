def solution(s, n):
    up_alpha = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'
    ,'Q','R','S','T','U','V','W','X','Y','Z']
    low_alpha = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    answer = ''
    for alpha in s:
        if alpha.isupper():
            for i in range(len(up_alpha)):
                if up_alpha[i] == alpha:
                   answer += up_alpha[(i+n) % len(up_alpha)]
        elif alpha.islower():
            for i in range(len(low_alpha)):
                if low_alpha[i] == alpha:
                    answer += low_alpha[(i+n) % len(low_alpha)]
        else:
            answer += alpha
    return answer