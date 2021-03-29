x = int(input())
y = int(input())

if 1 <= x <= 1000:
    if 1 <= y <= 1000:
        print('1')
    elif -1000 <= y <= -1:
        print('4')

elif -1000 <= x <= -1:
    if 1 <= y <= 1000:
        print('2')
    elif -1000 <= y <= -1:
        print('3') 