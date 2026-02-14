import java.util.*;

class Solution {
    
    static int cnt;
    static int result;
    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        dfs(alphabet, 0, "", word);
        
        return result;
    }
    
    void dfs(char[] alpha, int depth, String out, String word){
        
        if(out.equals(word)){
            result = cnt;
            return;  
        } 
        if(depth == 5){
            return;
        }
        
        for(int i=0; i<alpha.length; i++){
            cnt++;
            dfs(alpha, depth + 1, out + alpha[i], word);
        }
        return;
    }
    
    
}