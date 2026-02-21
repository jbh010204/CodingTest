import java.util.*;
import java.lang.*;
import java.io.*;

// Long 으로 해야할듯
// 부분합 ->  단조 증가 형태를 가지고 있어야 함.
//
class Main {
    static long T;
    static int N, M;
    static Map<Long, Long> a = new HashMap<>();
    static Map<Long, Long> b = new HashMap<>();
        
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Long.parseLong(br.readLine());

        
        N = Integer.parseInt(br.readLine());
        int[] al = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<al.length; i++){
            al[i] = Integer.parseInt(st.nextToken());    
        }

        M = Integer.parseInt(br.readLine());
        int[] bl = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<bl.length; i++){
            bl[i] = Integer.parseInt(st.nextToken());    
        }

        make_subset(al, a);
        make_subset(bl, b);
        
        
        long ans = 0L;

        for(long k : b.keySet()){
    
            if(a.containsKey(T-k)){
                ans += (a.get(T-k) * b.get(k));
            }    
        }

        System.out.println(ans);
    }

    static void make_subset(int[] arr, Map<Long,Long> map){
        int len = 1;
        for(int i=0; i<arr.length; i++){
            len = i;
            long sum = 0L;
            while(len < arr.length){
                sum += (long) arr[len++];
                map.put(sum, map.getOrDefault(sum, 0L) + 1L);
            }
            
        }
    }
}