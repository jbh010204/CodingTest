from collections import deque

def solution(n, computers):
    answer = 0
    visited = set([])
    def bfs(st):
        queue = deque([st])
        visited.add(st)
        
        while queue:
            v = queue.popleft()
            
            for idx,key in enumerate(computers[v]):
                
                if key == 1 and idx not in visited:
                    queue.append(idx)
                    visited.add(idx)
                    print(idx, end = " ")
        
    for i in range(n):
        if i not in visited:
            answer += 1
            bfs(i)
        
    return answer