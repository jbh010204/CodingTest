import java.util.*;
import java.lang.*;
import java.io.*;

// 정렬해서 
class Main {
    static class Data{
        int w;
        int p;

        public Data(int w, int p){
            this.w=w;
            this.p=p;
        }
    }
    
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];

        Data[] items = new Data[N];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            items[i] = new Data(w,p);
        }

        for(int i=0; i<items.length; i++){
            int w = items[i].w;
            int p = items[i].p;
            for(int k=K; k-w >= 0; k--){
                dp[k] = Math.max(dp[k], dp[k-w] + p);
            }
        }

        System.out.println(dp[K]);
        
    }
}