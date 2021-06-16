def solution(number, k):
    stack = [number[0]]
    for num in number[1:]:
        # 뒤의 수가 앞의 stack의 수보다 크면 stack에서 작은 수 제거
        while len(stack) != 0 and stack[-1] < num and k > 0:
            stack.pop()
            k -= 1
        stack.append(num)
    # 위에서 k만큼 제거 다 못했을 경우 뒤에서 남은 수만큼 빼주기     
    if k != 0:
        stack = stack[:-k]
            
    return "".join(stack)