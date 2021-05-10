def solution(s):
    answer = []
    for word in s.lower().split(" "):
        answer.append(word.capitalize())
    return " ".join(answer)