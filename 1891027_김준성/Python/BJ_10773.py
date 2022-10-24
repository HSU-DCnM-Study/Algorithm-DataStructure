arr = []
k = int(input())
for _ in range(k):
    num = int(input())
    if num != 0:
        arr.append(num)
    else:
        arr.pop()

answer = sum(arr)
print(answer)