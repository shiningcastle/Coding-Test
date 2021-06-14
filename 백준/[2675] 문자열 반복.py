n = int(input())
lis = []

for i in range(n):
    number, inp_string = input().split()
    lis.append((int(number), inp_string))
    
for tup in lis:
    for t in tup[1]:
        for _ in range(tup[0]):
            print(t , end='')
    print()