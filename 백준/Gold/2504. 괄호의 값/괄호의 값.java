import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        Deque<Integer> dq = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int res = 0;
        for(int i=0; i<str.length(); i++){
           int sum = 0;
           char s = str.charAt(i);
           if(s == '(') dq.offerLast(-1);
           if(s == '[') dq.offerLast(-2);
           if(s == ')' || s == ']'){
               int open = (s == ')') ? -1 : -2;
               int mul = (s == ')')  ? 2 : 3;

               boolean matched = false;
               while(!dq.isEmpty()){
                   int t = dq.pollLast();
                   if(t > 0) sum += t;
                   else if(t == open){
                       matched=true;
                       dq.offerLast(mul* (sum == 0 ? 1 : sum));
                       break;
                   }
                   else{
                       System.out.println(0);
                       return;
                   }
               }

               if(!matched){
                       System.out.println(0);
                       return;
               }
           }
        }

        while(!dq.isEmpty()){
            if(dq.peekLast() > 0){
                res += dq.pollLast();
                continue;
            } 
            System.out.println(0);
            return;
        }
        
        
        System.out.println(res);
    }
}