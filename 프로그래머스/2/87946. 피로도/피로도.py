from itertools import permutations

def solution(k, dungeons):
    explore = 0

    for i in permutations(dungeons, len(dungeons)):
        ct = 0
        ory = k
        for needy, usy in i:
            if needy <= ory:
                #print(ory, needy, usy)
                
                ory -= usy
                ct +=1
            else:
                break
        if(explore < ct):
            explore = ct
                
    answer = explore
    return answer