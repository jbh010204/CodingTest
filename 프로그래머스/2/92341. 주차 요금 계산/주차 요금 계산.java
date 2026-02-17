import java.util.*;


// 기본시간 넘음
// 있던 시간 - 기본 시간 = 126
// 추가 단위 시간 = 60
// 몫 * 추가요금 + if(나머지가 0 아니면 추가요금 ++ )

class Solution {
    static int DEFAULT_TIME = 0;
    static int DEFAULT_FEE = 0;
    static int ADDITIONAL_TIME = 0;
    static int ADDITIONAL_FEE = 0;
    
    static Map<String, Integer> map = new HashMap<>();
    static Map<String, Integer> treeMap = new TreeMap<>();
        
    public int[] solution(int[] fees, String[] records) {
        DEFAULT_TIME = fees[0];
        DEFAULT_FEE = fees[1];
        ADDITIONAL_TIME = fees[2];
        ADDITIONAL_FEE = fees[3];
        
        for(String s : records){
            String[] str = s.split(" ");
            String[] t = str[0].split(":");
            int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            String num = str[1];
            
            if(str[2].equals("IN")) map.put(num, time);
            else{
                // IN 했다고 가정
                int diff = time - map.get(num);
                map.remove(num);
                treeMap.put(num, treeMap.getOrDefault(num, 0) + diff);
            }
        }
        
        //23:59 출차
        for(String num : map.keySet()){
            int inTime = map.get(num);
            int outTime = 23*60 + 59;
            int diff = outTime - inTime;
            treeMap.put(num, treeMap.getOrDefault(num, 0) + diff);
        }
        
        int[] res = new int[treeMap.size()];
        int idx = 0;
        for(String key : treeMap.keySet()){
            int total = treeMap.get(key);
            res[idx++] = calculate(total);
        }
        
        
        return res;
    }
    
    static int calculate(int diff){
        int fee = DEFAULT_FEE;
            if(diff > DEFAULT_TIME){
                diff -= DEFAULT_TIME;
                int d = diff/ADDITIONAL_TIME;
                int r = diff%ADDITIONAL_TIME;

                fee += (d*ADDITIONAL_FEE);
                if(r > 0) fee += ADDITIONAL_FEE;
            }
        return fee; 
    }
}