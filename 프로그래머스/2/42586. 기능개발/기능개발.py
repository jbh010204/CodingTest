from collections import deque

def solution(progresses, speeds):
    answer = []
    
    dev = []
    idx = 0
    
    pushed = [False for i in range(len(progresses))]
    print(pushed)
    for k in range(10):
        for i, item in enumerate(progresses):
            print(pushed)
            if pushed[i] == False:
                progresses[i] += speeds[i]
                if(progresses[i] >= 100):
                    print("i입니다", i)
                    dev.append(i)
                    pushed[i] = True
                    
        ct = 0
        print("dev!!!!!!!!", dev)
        while True:
            # 만약 지금 배포가능성 있다면
            if idx in dev:
                dev.remove(idx)
                print("pop!!", idx)
                idx += 1
                ct += 1
            else:
                if (ct != 0):
                    answer.append(ct)
                break
            
        if(ct != 0):
            answer.append(ct)
        print("dev", dev)
        print("answer", answer)
                
        
    return answer