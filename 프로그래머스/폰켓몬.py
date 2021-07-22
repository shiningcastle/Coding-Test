def solution(nums):
    answer = 0
    check = []
    length = len(nums) // 2

    for num in nums:
        if answer == length:
            break
        if check.count(num) == 0:
            check.append(num)
            answer += 1
    return answer