
from collections import deque

def bfs(maze, row,col):
    dx = [-1, 1, 0, 0] #상 하 좌 우
    dy = [0, 0, -1, 1]

    queue = deque([(0,0)])

    while queue:
        x, y = queue.popleft()

        for i in range(4):         
            nx, ny = x+dx[i], y+dy[i]
            if nx < 0 or ny < 0 or nx >= row or ny >= col:
                continue

            if maze[nx][ny] == 1:
                maze[nx][ny] = maze[x][y] + 1
                queue.append((nx,ny))
    return maze[row-1][col-1]

row, col = map(int, input().split())
maze = [list(map(int, input().strip())) for _ in range(row)]

ans = bfs(maze,row,col)
print(ans)
    