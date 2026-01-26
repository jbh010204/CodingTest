import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num;
        for(int i=0; i<N; i++){
            num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            num = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(num, 0) + " ");
        }

        System.out.println(sb.toString());
        
    }
}