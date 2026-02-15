class Solution {
    static int[][] matrix = new int [][] {{1,1,1}, {5,1,1}, {25,5,1}};
    static int tired = 100000000;
    
    public int solution(int[] picks, String[] minerals) {
        int remainPicks = 0;
        for(int i=0; i<picks.length; i++){
            remainPicks += picks[i];
        }
        
        dfs(0,0,minerals, picks,remainPicks);
        
        return tired;
    }

    void dfs(int idx, int cntTired, String[] minerals, int[] picks, int remainPicks){
        
        if(remainPicks == 0 || idx == minerals.length){
            tired = Math.min(tired, cntTired);
            return;
        }

        for(int i=0; i<3; i++){
            if(picks[i] > 0) {
                picks[i]--;
                
                int tempTired = cntTired;
                int tempIdx = idx;
                
                for(int k = 0; tempIdx < minerals.length && k<5; k++){
                    tempTired += calculate(minerals[tempIdx++], i);
                }
                    
                dfs(tempIdx, tempTired , minerals, picks, remainPicks - 1);
                    
                picks[i]++;
            }
        }
    }
    
    int calculate(String rocks, int picksIdx){
        if(rocks.equals("diamond")){
            return matrix[picksIdx][0];
        }
        else if(rocks.equals("iron")){
            return matrix[picksIdx][1];
        }
        else{
            return matrix[picksIdx][2];
        }
    }
}
