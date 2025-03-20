from collections import deque

def solution(progresses, speeds):
    answer = []
    
    dev = []
    idx = 0
    
    pushed = [False for i in range(len(progresses))]
    print(pushed)
    while idx != len(speeds):
        for i, item in enumerate(progresses):
            if pushed[i] == False:
                progresses[i] += speeds[i]
                if(progresses[i] >= 100):
                    dev.append(i)
                    pushed[i] = True
                    
        ct = 0
        while True:
            # 만약 지금 배포가능성 있다면
            if idx in dev:
                dev.remove(idx)
                idx += 1
                ct += 1
            else:
                if (ct != 0):
                    answer.append(ct)
                break
            
    
                
        
    return answer