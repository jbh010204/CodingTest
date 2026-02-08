import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static boolean[] selfNums = new boolean[10001];
    
    public static void main(String[] args) throws IOException{
        Arrays.fill(selfNums, true);        
        for(int i=1; i<10000; i++){
            String num = Integer.toString(i);
            while(true){
                num = dN(num);
                if(Integer.parseInt(num) > 10000){
                    break;
                }
            }  
        }
        

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10000; i++){
            if(selfNums[i]){
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }

    static String dN(String num){
        int res = Integer.parseInt(num);
        for(int i=0; i<num.length(); i++){
            res += (num.charAt(i) - '0');
        }
        if(res <= 10000){
            selfNums[res] = false;
        }
        return Integer.toString(res);
    }
}

