import string

input_string = input()
lower = string.ascii_lowercase

diction = {key : -1 for key in dict.fromkeys(lower)}

for i in range(len(input_string)):
    if diction[input_string[i]] == -1:
        diction[input_string[i]] = i

for s in diction.values():
    print(s, end=' ')