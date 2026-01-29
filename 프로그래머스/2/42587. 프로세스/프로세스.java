class Solution {
    public int solution(int[] priorities, int location) {
        int idx = 0;
        int answer = 0;
        while(priorities[location] != -1){
            if(isProcess(idx, priorities)){
                answer++;
                priorities[idx] = -1;
            }
            
            idx++;
            idx = idx % priorities.length;
        }
        
        return answer;
    }
    
    boolean isProcess(int idx, int[] priorities){
        int maxNum = priorities[idx];
        
        for(int i=0; i<priorities.length; i++){
            if(maxNum < priorities[i]){
                return false;
            }
        }
        
        return true;
    }
}