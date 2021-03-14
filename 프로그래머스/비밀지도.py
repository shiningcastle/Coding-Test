def solution(n, arr1, arr2):

    answer = []

    for i in range(len(arr1)):
        # binary 숫자 앞에 '0b' 제거하기 위해 [2:]
        answer.append(bin(arr1[i] | arr2[i])[2:])
    
    for j in range(len(answer)):
        # 이진수가 변길이 만큼 숫자길이가 안나오면 앞에 0을 채워주기 위한 함수
        answer[j] = answer[j].zfill(n)

        answer[j] = answer[j].replace("1", "#")
        answer[j] = answer[j].replace("0", " ")
        
    return answer
