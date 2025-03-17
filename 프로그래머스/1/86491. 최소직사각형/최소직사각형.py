def solution(sizes):
    x = 0
    y = 0
    
    for card in sizes:
        a,b = card
        
        if a < b:
            a,b = b,a
    
        x = max(x, a)
        y = max(y, b)
    
    answer = x*y
    return answer