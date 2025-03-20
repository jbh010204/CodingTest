def solution(participant, completion):
    answer = ''
    temp = 0
    dic = {}
    for i in participant:
        dic[hash(i)] = i
        temp += int(hash(i))
    
    for i in completion:
        temp -= hash(i)
    
    answer = dic[temp]

    return answer

