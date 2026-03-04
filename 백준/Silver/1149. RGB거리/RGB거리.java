import java.util.*;
import java.lang.*;
import java.io.*;



class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][4];
        int[][] dp = new int[N+1][4];
        
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=3; i++){
            dp[1][i] = arr[1][i];
        }

        for(int i=2; i<=N; i++){
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + arr[i][2];
            dp[i][3] = Math.min(dp[i-1][2], dp[i-1][1]) + arr[i][3];  
        }

        System.out.println(Math.min(dp[N][1],Math.min(dp[N][2],dp[N][3])));
    }
}