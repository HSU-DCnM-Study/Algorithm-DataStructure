arr[]
answer = 0

k = int(input())
for _ in renge(k):
    num = int(input())
    if num != 0:
        arr.append(num)
    else:
        arr.pop()

for n in arr:
    answer += n

print(answer)
    
