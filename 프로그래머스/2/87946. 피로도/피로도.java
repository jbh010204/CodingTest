import java.util.*;

class Solution {
    static int max = 0;
    static int len = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        len = dungeons.length;
        boolean[] visited = new boolean[len];
        dfs(dungeons, k, 0, 0, visited);
        return max;
    }
    
    void dfs(int[][] arr, int k, int depth, int cnt, boolean[] visited){
        if(depth == len){
            max = Math.max(cnt, max);
            return;
        }
        
        boolean flag = false;
        for(int i=0; i<len; i++){
            if(!visited[i] && arr[i][0] <= k){
                visited[i] = true;
                flag = true;
                
                dfs(arr, k - arr[i][1], depth + 1, cnt + 1, visited);
                visited[i] = false;   
            }
        }
        
        if(!flag) max = Math.max(cnt, max);
        
        return;
    }
}