import java.util.*;
import java.io.*;

class Solution {
    static class Data{
        String key;
        int cnt;
        
        Data(String key, int cnt){
            this.key = key;
            this.cnt = cnt;
        }
    }
    
    static int minLen = 0;
    public int solution(String s) {
        minLen = s.length();
        
        for(int i=1; i<s.length(); i++){
            compact(i, s);
        }
        
        return minLen;
    }
    
    void compact(int unit, String s){
        StringBuilder sb = new StringBuilder();
        Deque<Data> list = new ArrayDeque<>();
        
        int idx = 0;
        String preWord = "";
        
        while(idx < s.length()){
            String word = "";
            if(idx + unit <= s.length()){
                word = s.substring(idx, idx+unit);
                
                if(word.equals(preWord)){
                    Data d = list.pollLast();
                    d.cnt += 1;
                    
                    list.offerLast(d);
                
                } else{
                    list.offerLast(new Data(word, 1));
                }
                
                preWord = word;
                idx+=unit;
                continue;
            }
            word = s.substring(idx, s.length());
            idx = s.length();
            
            list.offerLast(new Data(word, 1));
        }
        
        for(Data d : list){
            String key = d.key;
            int val = d.cnt;
            
            if(val > 1) sb.append(val+key);
            else sb.append(key);
        }
        
        minLen = Math.min(minLen, sb.length());
        
        return;
    }
    

}