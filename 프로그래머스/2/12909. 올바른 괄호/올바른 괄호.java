import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cnt = 0;
        Queue<Character> q = new LinkedList<>();
    
        for(int i=0; i<s.length(); i++){
            q.offer(s.charAt(i));
        }
        
        while(!q.isEmpty() && (cnt >= 0)){
            char curr = q.poll();
            if(curr == '('){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        
        if(cnt!=0){
            answer=false;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}