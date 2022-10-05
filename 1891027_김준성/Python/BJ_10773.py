arr = []
k = int(input())
for _ in range(k):
    num = int(input())
    if num != 0:
        arr.append(num)
    else:
        arr.pop()

# for n in arr:
#     print(n)
#     answer += n

answer = sum(arr)
print(answer)