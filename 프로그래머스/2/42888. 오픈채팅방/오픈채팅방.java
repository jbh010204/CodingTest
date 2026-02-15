import java.util.*;

// 문제 조건 잘 읽고 코드의 생각을 담아서

// 1. 채팅방 나갔다 들어오면서 변경
// 2. 채팅방 내에서 변경
// ! 중복 허용

class Solution {
    
    
    // record 돌아가면서 Enter Leave Change 분기 구분
    // enter, change -> 이름 바뀌었는지 UID key로 value확인
    // enter leave 면 List에 add
    
    static int idx = 0;
    static String[] commands = {"님이 들어왔습니다.", "님이 나갔습니다."};
    static String[] res;
    
    static class Data{
        int idx;
        int cmd;

        Data(int idx, int cmd){
        this.idx = idx;
        this.cmd = cmd;
    }
}
        
    public String[] solution(String[] record) {
        Map<String, String> nameMap = new HashMap<>();
        Map<String, List<Data>> dataMap = new HashMap<>();
        
        for(String r : record){
            String[] tmp = r.split(" ");
            
            String cmd = tmp[0];
            String uid = tmp[1];
            
            if(cmd.equals("Enter")){
                String name = tmp[2];
                nameMap.put(uid, name);
                List<Data> d = dataMap.getOrDefault(uid, new ArrayList<>());
                d.add(new Data(idx++, 0));
                dataMap.put(uid, d);
            }
            else if(cmd.equals("Change")){
                String name = tmp[2];
                nameMap.put(uid, name);
            }
            else{
                List<Data> d = dataMap.getOrDefault(uid, new ArrayList<>());
                d.add(new Data(idx++, 1));
                dataMap.put(uid, d);
            }
        }
        
        res = new String[idx];
        for(Map.Entry<String, List<Data>> entry : dataMap.entrySet()){
            String uid = entry.getKey();
            List<Data> list = entry.getValue();
            
            String name = nameMap.get(uid);
            for(Data d : list){
                res[d.idx] = name + commands[d.cmd];
            }
        }
        
        return res;
    
    }
}