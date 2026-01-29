import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx = 0; 
    
        Deque<Integer> dq = new ArrayDeque<>(bridge_length);
        for(int i=0; i<bridge_length; i++){
            dq.add(0);
        }    
        
        int curWeight = 0;
        while(!dq.isEmpty()){
            
            int wei = dq.pollFirst();
            answer += 1;
            curWeight -= wei;
            
            if (idx == truck_weights.length){
                continue;
            } 
            
            if(curWeight + truck_weights[idx] <= weight){
                curWeight += truck_weights[idx];
                dq.offerLast(truck_weights[idx]);
                idx++;
            }
            else{
                dq.offerLast(0);
            }
        }

        return answer;
    }
}