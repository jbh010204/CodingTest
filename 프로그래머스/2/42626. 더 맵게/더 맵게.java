import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        int cnt = 0;
        while(pq.peek() < K && !pq.isEmpty()){
            if(pq.size() <= 1) return -1;
            
            int a = pq.poll();
            int b = pq.poll();
            
            cnt++;
            pq.add(a + b*2);
        }
        
        return cnt;
    }
}