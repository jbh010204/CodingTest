import java.util.*;

class Solution {
    // J(A,B) -> (A교B) % (A U B) 중복가능
    static Map<String, Integer> map1;
    static Map<String, Integer> map2;
    static String regex = "^[a-zA-Z]*$";
    static int N;
    static int M;
    public int solution(String str1, String str2) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        
        
        //입력
        push(map1, str1);
        push(map2, str2);
        
        if(map1.size() == 0 && map2.size() == 0){
            return 65536;
        }
        
        //교집합
        intersection(map1,map2);
        //합집합
        union(map1,map2);
        
        double res = (double)N / (double)M;     
        int answer = (int) (res * 65536);
        return answer;
    }
    
    static private void push(Map<String,Integer> map ,String str){
        str = str.toUpperCase();
        
        for(int i=0; i<str.length()-1; i++){
            String tmp = "";
            tmp += str.charAt(i);
            tmp += str.charAt(i+1);
            
            if(tmp.matches(regex)){
                System.out.println(tmp);
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);    
            }
            
        }
    }
    
    static private void intersection(Map<String,Integer> map1, Map<String,Integer> map2){
        for(Map.Entry<String, Integer> e : map1.entrySet()){
            String key = e.getKey();
            int value = e.getValue();
            
            if(map2.containsKey(key)){
                N += Math.min(value, map2.get(key));
            }
        }
    }
    
    static private void union(Map<String,Integer> map1, Map<String,Integer> map2){
        for(Map.Entry<String, Integer> e : map1.entrySet()){
            String key = e.getKey();
            int value = e.getValue();
            
            if(map2.containsKey(key)){
                M += Math.max(value, map2.get(key));
            }
            else{
                M += value;
            }
        }
        
        for(Map.Entry<String, Integer> e : map2.entrySet()){
            String key = e.getKey();
            int value = e.getValue();
            
            if(!map1.containsKey(key)){
                M += value;
            }
        }
    }
}