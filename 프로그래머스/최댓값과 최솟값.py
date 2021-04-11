def solution(s):
    
    # 각각의 숫자 문자열을 정수로 변환해 넣어줄 빈 리스트 선언
    a = []
    
    for i in range(0, len(s)):
        # 빈칸을 발견하면 그 앞 빈칸을 만나거나 0인 인덱스나 마지막 인덱스 를 만나면 
        # 그 다음 인덱스부터 뒤의 빈칸 한칸 앞 인덱스까지 순서대로 문자로 합쳐서 int로 변환
        
        if(s[i] == " "):
            for j in range(i-1, -1, -1):
                
                # 첫번째 인덱스 만났을 때
                if (j == 0):
                    b = ""
                    for k in range(j, i, 1):
                        b += s[k]
                    a.append(int(b))
                    break
                
                # 처음, 마지막 아닌 경우에 빈칸을 만났을 때
                elif (s[j] == " "):
                    b = ""
                    for k in range(j+1, i):
                        b += s[k]
                    a.append(int(b))
                    break
                
                # 빈칸 아닌 경우 아무 과정없이 지나침
                else:
                    continue
        
        # 마지막 인덱스 만났을 때
        elif(i == len(s)-1):
            for u in range(len(s)-1, -1, -1):
                if (s[u] == " "):
                    b = ""
                    for k in range(u+1, i+1):
                        b += s[k]
                    a.append(int(b))
                    break
    max = a[0]
    min = a[0]  
    
    # 리스트 a에서 하나씩 뽑아와 비교해서 최소값 최대값 정함
    for k in a:
        if(k < min):
            min = k
        elif(k > max):
            max = k
    
    # 리턴 값을 정답 형태로 만들어 줌
    answer = str(min) + " " + str(max)
    return answer