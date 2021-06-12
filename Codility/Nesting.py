def solution(S):
    count = 0

    for s in S:
        if count < 0:
            return 0

        if s == "(":
            count += 1
        else:
            count -= 1

    if count == 0:
        return 1
    else:
        return 0