import java.util.*;
import java.lang.*;
import java.io.*;

// 연속되는 부분합 -> prefix + HashMap
class Main {

    static int N;
    static Long K;
    static Long arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        arr = new Long[N];
        Map<Long, Long> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        //0부터 시작하는 부분합도 고려
        map.put(0L, 1L);

        Long sum = 0L;
        Long cnt = 0L;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            
            long key = sum - K;
            if(map.containsKey(key)){
                cnt += map.get(key);
            }

            map.put(sum, map.getOrDefault(sum,0L) + 1L);
        
        }

        System.out.println(cnt);
    }
}