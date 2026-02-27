import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];

        if(N >= 2){
            dp[2] = arr[2] + arr[1];
            
        }
        else {
            System.out.println(dp[1]);
            return;
        }

        for(int i=3; i<=N; i++){
            dp[i] = Math.max(arr[i] + dp[i-2] , arr[i] + arr[i-1] + dp[i-3]);    
        }
        
        System.out.println(dp[N]);
    }
}