from collections import deque

def solution(maps):
    answer = 0
    
    row,col = len(maps), len(maps[0])
    
    def bfs(row, col):
        # 상 하 좌 우
        dx = [-1,1,0,0]
        dy = [0,0,-1,1]

        q = deque([(0,0)])
        visited = set([(0,0)])

        while q:
            x,y = q.popleft()

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 > nx or nx >= row or 0 > ny or ny >= col:
                    continue

                if maps[nx][ny] == 1 and (nx,ny) not in visited:
                    #print(nx,ny)
                    maps[nx][ny] = maps[x][y] + 1
                    q.append((nx,ny))
                    visited.add((nx,ny))
    bfs(row,col)
    if maps[row-1][col-1] == 1:
        answer = -1
    else:
        answer = maps[row-1][col-1]
    
    return answer

