import java.util.*;

class Solution {
    static int cnt = 0;
    static int N = 0;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        binary(numbers, 0, target, 0);
        return cnt;
    }
    
    void binary(int[] numbers, int idx, int target, int out){
        if(idx == N){
            if(out == target) cnt ++;
            return;
        }
        
        binary(numbers, idx+1, target, out+ numbers[idx]);
        binary(numbers, idx+1, target, out- numbers[idx]);
        
        return;
    }
}