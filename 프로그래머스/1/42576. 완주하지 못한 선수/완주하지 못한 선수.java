import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i],0) + 1);
        }
        
        for(int i=0; i<completion.length; i++){
            map.put(completion[i], map.getOrDefault(completion[i],0) - 1);
        }
        
        List<String> keys = new ArrayList<>(map.keySet());
        
        keys.sort((o1,o2) -> map.get(o2) - map.get(o1));
        
        return keys.get(0);
    }
}