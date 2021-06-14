import string

alphabet = string.ascii_uppercase
dic = {key : 0 for key, value in dict.fromkeys(alphabet).items()}
input_string = input().upper()

for s in input_string:
    dic[s] += 1
    
answer = [key for key, value in dic.items() if max(dic.values()) == value]
    
if len(answer) == 1:
    print(answer[0])
else:
    print("?")