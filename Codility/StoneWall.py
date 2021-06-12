def solution(H):
    stack = list()
    count = 0
    for h in H:
        while len(stack) != 0 and stack[-1] > h:
            stack.pop()
        if len(stack) == 0 or stack[-1] < h:
            count += 1
            stack.append(h)

    return count