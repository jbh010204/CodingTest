from collections import defaultdict
from collections import deque

def bfs (visited, st, tree):
    ct = 0
    q = deque([st])
    
    while q:
        v = q.popleft()
        for i in tree[v]:
            if i not in visited:
                q.append(i)
                visited.add(i)
                ct += 1
    return ct

def solution(n, wires):
    answer = -1
    visited = set([])
    tree = defaultdict(list)
    for key, val in wires:
        tree[key].append(val)
        tree[val].append(key)
    mnum = n
    for key, val in tree.items():
        for i in val:
            visited.add(key)
            ct = bfs(visited, i, tree)
            if ( abs((n - ct) - ct) < mnum):
                mnum = abs((n - ct) - ct)
            visited = set([])
    
    return mnum