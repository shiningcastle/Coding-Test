def solution(A):
    ans = [True for i in range(1, len(A) + 2)]

    for a in A:
        ans[a-1] = False

    return ans.index(True) + 1