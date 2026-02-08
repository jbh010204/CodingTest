import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = new int[N+1];
        P = new int[N+1];
        dp = new int[N+2];

        StringTokenizer st;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            if(i+1 <= N+1){
                dp[i+1] = Math.max(dp[i], dp[i+1]);   
            }

            int nx = i+T[i];
            if(nx <= N+1){
                dp[nx] = Math.max(dp[nx], dp[i] + P[i]); 
            }
        }

        
        System.out.println(dp[N+1]);
        return;
    }
}
