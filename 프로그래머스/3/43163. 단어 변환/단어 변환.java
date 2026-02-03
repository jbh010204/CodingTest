import java.util.*;

class Solution {
    class Words{
        String word;
        int count;
        
        Words(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Deque<Words> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        dq.offer(new Words(begin, 0));
        while(!dq.isEmpty()){
            Words w = dq.poll();
            
            if(w.word.equals(target)){
                return w.count;            
            }
                    
                
            for(int i=0; i<words.length; i++){
                if(!visited[i] && canTranslate(w.word, words[i])){
                
                    //System.out.println(cnt + " " + words[i]);
                    dq.offer(new Words(words[i], w.count + 1));
                    visited[i] = true;
                }
                
            }
        }
        
        return 0;
    }
    
    public boolean canTranslate(String a, String b){
        int tmp = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                tmp++;
            }
            
            if(tmp > 1){
            return false;
            }
        }
        
        return true;
    }
}