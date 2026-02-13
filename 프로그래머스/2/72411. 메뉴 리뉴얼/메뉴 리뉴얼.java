import java.util.*;

class Solution {
    
    static Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {        
        List<String> res = new ArrayList<>();
        for(int c : course){
            map = new HashMap<>();
            
            for(String order: orders){
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                dfs(new String(arr), "", 0, c);
            }
            if(!map.isEmpty()){
                int max = Collections.max(map.values());
                if(max >=2) {
                    for(String key : map.keySet()){
                       if(max == map.get(key))  res.add(key);
                    }
                }
            }
                
        }
        
        Collections.sort(res);
        return res.toArray(new String[0]);
    }
    
    static void dfs(String orders, String tmp, int start, int depth){
        if(tmp.length() == depth){
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            return;
        }
        
        for(int i=start; i<orders.length(); i++){
            dfs(orders, tmp + orders.charAt(i), i+1, depth);
        }
        
    }
}