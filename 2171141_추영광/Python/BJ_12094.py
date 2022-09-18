import sys
input = sys.stdin.readline

def move(arr, cnt = 0, M = 1):
    global MaxValue
    if cnt >= 10 or (MaxValue >= (M * (1 << (10-cnt)))):
        return max(M, MaxValue)
    cache = M

    C = [i[:] for i in arr]
    no_move = True
    for x in range(n):
        add = 0
        for y in range(1, n):
            if not C[y][x]: continue
            if C[y][x] == C[add][x]:
                C[add][x] *= 2
                M = max(C[add][x], M)
                C[y][x] = 0
                add += 1
                no_move = False
            elif C[add][x] == 0:
                C[add][x] = C[y][x]
                C[y][x] = 0
                no_move = False
            elif add+1 != y:
                add += 1
                C[add][x] = C[y][x]
                C[y][x] = 0
                no_move = False
            else:
                add += 1
    if not no_move: MaxValue = max(move(C, cnt+1, M), MaxValue, M)

    C = [i[:] for i in arr]
    no_move = True
    M = cache
    for x in range(n):
        add = n-1
        for y in range(n-2, -1, -1):
            if not C[y][x]: continue
            if C[y][x] == C[add][x]:
                C[add][x] *= 2
                M = max(C[add][x], M)
                C[y][x] = 0
                add-=1
                no_move = False
            elif C[add][x] == 0:
                C[add][x] = C[y][x]
                C[y][x] = 0
                no_move = False
            elif add-1 != y:
                add -= 1
                C[add][x] = C[y][x]
                C[y][x] = 0
                no_move = False
            else:
                add -= 1
    if not no_move: MaxValue = max(move(C, cnt+1, M), MaxValue, M)

    C = [i[:] for i in arr]
    no_move = True
    M = cache
    for y in range(n):
        add = 0
        for x in range(1, n):
            if not C[y][x]: continue
            if C[y][x] == C[y][add]:
                C[y][add] *= 2
                M = max(C[y][add], M)
                C[y][x] = 0
                add += 1
                no_move = False
            elif C[y][add] == 0:
                C[y][add] = C[y][x]
                C[y][x] = 0
                no_move = False
            elif add+1 != x:
                add += 1
                C[y][add] = C[y][x]
                C[y][x] = 0
                no_move = False
            else:
                add += 1
    if not no_move: MaxValue = max(move(C, cnt+1, M), MaxValue, M)

    C = [i[:] for i in arr]
    no_move = True
    M = cache
    for y in range(n):
        add = n-1
        for x in range(n-2, -1, -1):
            if not C[y][x]: continue
            if C[y][x] == C[y][add]:
                C[y][add] *= 2
                M = max(C[y][add], M)
                C[y][x] = 0
                add-=1
                no_move = False
            elif C[y][add] == 0:
                C[y][add] = C[y][x]
                C[y][x] = 0
                no_move = False
            elif add-1 != x:
                add -= 1
                C[y][add] = C[y][x]
                C[y][x] = 0
                no_move = False
            else:
                add -= 1
    if not no_move: MaxValue = max(move(C, cnt+1, M), MaxValue, M)
    return MaxValue

n = int(input())
arr = [list(map(int, input().split())) for _ in ' '*n]
MaxValue = 0
for i in arr:
    MaxValue = max(MaxValue, max(i))
move(arr, MaxValue)
print(MaxValue)
