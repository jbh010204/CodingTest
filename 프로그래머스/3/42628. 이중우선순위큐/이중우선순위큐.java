import java.util.*;

class Solution {
    static String Qappend = "I";
    static String DMax = "D 1";
    static String DMin = "D -1";
    
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i<operations.length; i++){
            String str = operations[i];
            int num = 0;
            if(str.contains(Qappend)){ // 원소 입력
                str = str.replaceAll("[^0-9-]", "");
                num = Integer.parseInt(str);
                // System.out.println(num);
                
                map.put(num, map.getOrDefault(num,0) + 1);
                
            }
            if(str.equals(DMax)){ //최댓값 제거
                if(!map.isEmpty()){
                    int maxKey = map.lastKey();
                    if(map.put(maxKey, map.get(maxKey) -1) == 1){
                        map.remove(maxKey);    
                    }
                }
            }
            if(str.equals(DMin)){ //최솟값 제거
                if(!map.isEmpty()){
                    int minKey = map.firstKey();
                    if(map.put(minKey, map.get(minKey) -1) == 1){
                        map.remove(minKey);    
                    }
                }
            }
        }
        int[] answer = new int[] {0,0};
        if(!map.isEmpty()){
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }
        
        return answer;
    }
}