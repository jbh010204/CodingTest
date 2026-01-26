import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int idx = 0;
        int cnt = 0;
        int len = progresses.length;
        while(idx < len) {

            for(int i = 0; i <len; i++){
                progresses[i] += speeds[i];  
            }
            
            if(progresses[idx] >= 100){
                while(idx < len && progresses[idx] >= 100)                 {
                    idx++;
                    cnt++;
                    
                }
                
                list.add(cnt); 
                cnt = 0;
            }
            
        }
        
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}