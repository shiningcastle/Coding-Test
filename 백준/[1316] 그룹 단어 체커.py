import string

n = int(input())
alphabet = string.ascii_lowercase
lis = []
count = 0

for i in range(n):
    lis.append(input())

for i in range(len(lis)):
    check = True
    dic = {key : False for key, value in dict.fromkeys(alphabet).items()}
    ch = lis[i][0]
    restCh = lis[i][1:]
    for i in range(len(restCh)):
        if restCh[i] != ch:
            if dic[ch] == False:
                dic[ch] = True
                ch = restCh[i]
            else:
                check = False
                break
        if i == len(restCh) - 1:
            if dic[restCh[i]] == True:
                check = False

    if check:
        count += 1

print(count)