import java.util.*;
import java.lang.*;
import java.io.*;


// K <= N 
class Main {

    static int K, N;
    static long[] lan;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lan = new long[K];
        for(int i=0; i<K; i++){
            lan[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(lan);
            
        System.out.println(bs(1, lan[K-1], 0));
    }

    static long bs(long left, long right, long best){
        if(left > right) return best;
        
        long mid = left + (right - left)/2;
        long cnt = count(mid);
        if(cnt >= N) return bs(mid + 1, right, Math.max(mid, best));
        else return bs(left, mid - 1, best);
        
    }

    static long count(long len) {
        long sum = 0;
        for (long x : lan) sum += (x / len);
        return sum;
    }
}