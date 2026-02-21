class Solution {
    
    public long solution(int n, int[] times) {
        
        long left = 0L;
        long right = Long.MAX_VALUE;
        long ans = 0L;
        
        while(left <= right){
            long mid = (right - left)/2 + left;
            if(check(times, mid, n)){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        
        return ans;
        
    }
    
    static boolean check(int[] times, long x, int number){
        long cnt = 0;
        for(int t : times){
            cnt += x/t;
            if(number <= cnt) return true;
        }
        
        return false;
    }
}