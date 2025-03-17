def solution(answers):
    
    solves = [
        [1,2,3,4,5],
        [2,1,2,3,2,4,2,5],
        [3,3,1,1,2,2,4,4,5,5]]
    
    idx = [0,0,0]
    length = [len(solves[0]),len(solves[1]),len(solves[2])]
    ct = [0,0,0]
    
    for i in range(len(answers)):
        for j in range(3):
            if solves[j][i % len(solves[j])] == answers[i]:
                ct[j] += 1
    max_score = max(ct)
    
    answer = [i+1 for i in range(3) if ct[i] == max_score]
    return answer