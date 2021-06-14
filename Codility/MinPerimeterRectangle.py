import math

def solution(N):
    minimum = 1000000000 * 4

    for n in range(1, int(math.sqrt(N)) + 1):
        if N % n == 0:
            perimeter = 0
            if n ** 2 == N:
                perimeter = (2 * n) * 2
            else:
                perimeter = (n + (N // n)) * 2

            if perimeter < minimum:
                minimum = perimeter

    return minimum