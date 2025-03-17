from collections import deque

def ct_same_words(a,b):
    ct = 0
    for i in range(len(a)):
        if a[i] == b[i]:
            ct += 1
    return ct
    

def solution(begin, target, words):
    answer = 0
    
    if target not in words:
        return answer
    
    def bfs(begin, answer):
        q = deque([(begin,0)])
        visited = set([begin])
        ct = 0
        while q:
            v,idx = q.popleft()
            
            if v == target:
                return idx
            
            for word in words:
                if ct_same_words(v, word) == (len(word)-1):
                    if word not in visited:
                        #print(word)
                        visited.add(word)
                        q.append((word, idx+1))
    
    answer = bfs(begin, answer)     
    print(answer)
    return answer