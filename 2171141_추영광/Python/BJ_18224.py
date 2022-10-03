import sys 
from collections import deque
input = sys.stdin.readline
 
def lowerbound_x(x, y):
    l = 0; r = len(void_idx_x[y])-1
    while l < r:
        m = l + r >> 1
        if void_idx_x[y][m] >= x: r = m 
        else: l = m + 1
    return r

def lowerbound_y(x, y):
    l = 0; r = len(void_idx_y[x])-1
    while l < r:
        m = l + r >> 1
        if void_idx_y[x][m] >= y: r = m
        else: l = m+1
    return r

vec = ((1,0), (-1,0), (0,1), (0,-1))
def bfs(x, y, t, walk):
    next_t = t + (walk+1) // m
    next_m = (walk+1) % m
    for dx, dy in vec:
        nx, ny = dx+x, dy+y
        if not (0 <= nx < n and 0 <= ny < n): continue
        if not t%2: # 낮
            if M[ny][nx] or ((1<<(next_t%2+10))|(1<<next_m) in visited[ny][nx]): continue
            d.append([nx, ny, next_t, next_m])
            visited[ny][nx].add(1<<(next_t%2+10)|1<<next_m)
        else:
            if not M[ny][nx] and not ((1<<(next_t%2+10))|(1<<next_m) in visited[ny][nx]):
                visited[ny][nx].add(1<<(next_t%2+10)|1<<next_m)
                d.append([nx, ny, next_t, next_m])
            elif M[ny][nx]:
                if dx:
                    k = lowerbound_x(x, y)
                    if (dx == -1 and k == 0) or (dx == 1 and k == len(void_idx_x[y])-1): continue
                    elif dx == -1: k = void_idx_x[y][k-1]
                    else: k = void_idx_x[y][k+1]
                    if not ((1<<(next_t%2+10))|(1<<next_m) in visited[ny][k]):
                        visited[ny][k].add(1<<(next_t%2+10)|1<<next_m)
                        d.append([k, ny, next_t, next_m])
                elif dy:
                    k = lowerbound_y(x, y)
                    if (dy == -1 and k == 0) or (dy == 1 and k == len(void_idx_y[x])-1): continue
                    elif dy == -1: k = void_idx_y[x][k-1]
                    else: k = void_idx_y[x][k+1]
                    if not ((1<<(next_t%2+10))|(1<<next_m) in visited[k][nx]):
                        visited[k][nx].add(1<<(next_t%2+10)|1<<next_m)
                        d.append([nx, k, next_t, next_m])

n, m = map(int, input().split())
M = list(list(map(int, input().split())) for _ in ' '*n)
visited = [[set() for _ in ' '*n] for _ in ' '*n]

void_idx_x = [[] for _ in ' '*n]
void_idx_y = [[] for _ in ' '*n]
for y, i in enumerate(M):
    for x, j in enumerate(i):
        if not j:
            void_idx_x[y].append(x)
            void_idx_y[x].append(y)

d = deque([[0, 0, 0, 0]])
while d:
    x, y, t, walk = d.popleft()
    if x == n-1 and y == n-1:
        print(1+t//2, ('sun','moon')[t%2])
        break
    bfs(x, y, t, walk)
else: print(-1)
