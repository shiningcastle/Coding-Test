import sys
inp = sys.stdin.readline

word = inp().strip()
ucpc = ["U", "C", "P", "C"]
check = True

for i in range(len(ucpc)):
    if ucpc[i] in word:
        idx = word.find(ucpc[i])
        word = word[idx+1: ]
    else:
        check = False
        break

if check:
    print('I love UCPC')
else:
    print('I hate UCPC')