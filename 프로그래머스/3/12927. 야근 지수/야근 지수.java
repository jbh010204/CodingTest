import java.util.*;


class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
        
        for(int i=0; i<n; i++){
            int key = pq.poll();
            if(key <= 0){
                break;
            }
            pq.offer(key - 1);
        }
        
        long res = 0;
        while(!pq.isEmpty()){
            int key = pq.poll();
            res += (long) (key * key);
        }   
        return res;
    }
}