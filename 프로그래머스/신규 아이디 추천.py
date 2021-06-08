import string

def solution(new_id):
    characters = string.ascii_lowercase + string.digits + "-" + "_" + "."
    # 1단계
    new_id = new_id.lower()
    # 2단계
    new_id = ''.join(x for x in new_id if x in characters)
    # 3단계
    while new_id.count("..") != 0:
        new_id = new_id.replace("..", ".")
    # 4단계
    if new_id[0] == "." and new_id[-1] == ".":
        new_id = new_id[1:len(new_id)-1]
    elif new_id[0] == ".":
        new_id = new_id[1:]
    elif new_id[-1] == ".":
        new_id = new_id[:len(new_id)-1]
    # 5단계
    if len(new_id) == 0:
        new_id = "a"
    # 6단계
    if len(new_id) >= 16:
        new_id = new_id[:15]
        if new_id[-1] == ".":
            new_id = new_id[:len(new_id)-1]
    # 7단계
    elif len(new_id) <= 2:
        while len(new_id) != 3:
            new_id += new_id[-1]
    
    return new_id