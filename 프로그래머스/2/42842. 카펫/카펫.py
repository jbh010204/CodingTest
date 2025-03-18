import math

def solution(brown, yellow):
    for i in range(1, int(math.sqrt(yellow)) + 1):  
        if yellow % i == 0:  
            width = max(i, yellow // i)  
            height = min(i, yellow // i)

            if (width + 2) * (height + 2) == brown + yellow:
                return [width + 2, height + 2]

    return []