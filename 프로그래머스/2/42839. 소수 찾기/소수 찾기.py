from itertools import permutations

def is_prime(n):
    
    if n < 2:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True

def solution(numbers):
    uni = set()
    
    iter = list(numbers)
    
    for j in range(1,len(numbers)+1):
        for i in permutations(iter , j):
            str = int("".join(i))
            uni.add(str)
    print(uni)
    
    return sum(1 for num in uni if is_prime(num))