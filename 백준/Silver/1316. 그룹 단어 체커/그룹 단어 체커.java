import java.util.*;
import java.lang.*;
import java.io.*;



class Main {
    static int N;
    static int cnt = 0;
    static HashMap<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String str = br.readLine();
            check(str);
        }

        System.out.println(cnt);
    }

    static void check(String str){
        map.clear();
        
        if(str.length() == 1){
            cnt++;
            return;
        }
        
        boolean isGroup = true;
        map.put(str.charAt(0),1);
        
        for(int i=1; i<str.length(); i++){
            char prev = str.charAt(i-1); 
            char c = str.charAt(i);

            // System.out.println(c + " " + map.containsKey(c));
            
            if(prev != c && map.containsKey(c)){
                isGroup = false;
                break;
            }
            else map.put(c,1);
        }

        if(isGroup) cnt++;
        return;
    }
}