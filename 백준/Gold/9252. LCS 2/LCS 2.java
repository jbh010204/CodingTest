import java.util.*;
import java.lang.*;
import java.io.*;
 
//2차원배열로 

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        StringBuilder sb = new StringBuilder();
        int N = str1.length();
        int M = str2.length();
        
        int[][] dp = new int[N+1][M+1];
        
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);            
            }
        }

        int i = N;
        int j = M;

        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--; j--;
            }
            else{
                if (dp[i - 1][j] >= dp[i][j - 1]) i--;
                else j--;
            }
        }

        System.out.println(dp[N][M]);
        System.out.println(sb.reverse().toString());
        
    }

}