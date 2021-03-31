start = input()

if int(start) < 10:
       start = str(0) + start
       
test = start
trynum = 0

while True:
    a = int(list(test)[0]) + int(list(test)[1])
    
    if a >= 10:
        test = list(test)[1] + list(str(a))[1]
    else:
        test = list(test)[1] + str(a)

    trynum += 1
    
    if test == start:
        break
        
print(trynum)