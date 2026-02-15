class Solution {
    static int[][] matrix = new int [][] {{1,1,1}, {5,1,1}, {25,5,1}};
    static int tired = 100000000;
    
    public int solution(int[] picks, String[] minerals) {
        int remainPicks = 0;
        for(int i=0; i<picks.length; i++){
            remainPicks += picks[i];
        }
        
        dfs(0,0,0,minerals,0, picks, remainPicks);
        
        return tired;
    }

    void dfs(int idx, int current, int cntTired, String[] minerals, int picksIdx, int[] picks, int remainPicks){
        
        while(current > 0){
            if(idx == minerals.length){
                tired = Math.min(tired, cntTired);            
                return;
            }    
            
            int i;
            if(minerals[idx].equals("diamond")){
                i = 0;
            }
            else if(minerals[idx].equals("iron")){
                i = 1;
            }
            else{
                i = 2;
            }
            
            cntTired += matrix[picksIdx][i];
            current--;
            idx ++;
            
        }
        
        
        if(current == 0){
            if(remainPicks == 0){
                tired = Math.min(tired, cntTired);            
                return;
            }
            
            for(int i=0; i<3; i++){
                if(picks[i] > 0) {
                    picks[i]--;
                    remainPicks--;
                    dfs(idx, 5, cntTired, minerals, i, picks, remainPicks);
                    picks[i]++;
                    remainPicks++;
                    
                }
            }
        }
    }
}
