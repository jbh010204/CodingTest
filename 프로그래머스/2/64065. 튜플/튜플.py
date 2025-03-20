from collections import deque

def q_pop(q):
    
    a = []
    tmp = ''
    #print(q)
    while q:
        num = q.popleft()
        if(num != ','):
            tmp += num
        else:
            a.append(int(tmp))
            tmp = ''
    if len(tmp) != 0:
        a.append(int(tmp))
    res = [a, len(a)]
    return res

def solution(s):
    answer = []
    
    q = deque([])
    res = []
    #길이 만큼 반복하면서 { 이거 나오면 스택에 넣고 } 이거 나오면 pop하고
    isopen = False
    
    for i in range(1, len(s)-1):
        if s[i] == '{':
            isopen = True
        elif s[i] == '}':
            res.append(q_pop(q))
            isopen = False
        elif isopen == True:
            q.append(s[i])
    res.sort(key = lambda x:x[1])
    #print(res)
    
    for val, idx in res:
        for i in val:
            if i not in answer:
                answer.append(i)
    return answer