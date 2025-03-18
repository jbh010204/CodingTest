def solution(nums):
    answer = 0
    
    unique_nums = set(nums)
    num = len(nums)//2
    
    if len(unique_nums) < num:
        answer = len(unique_nums)
    else:
        answer = num
    
    return answer