import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int max = 0;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        dp = new int[A.length() + 1][B.length()+ 1];

        find(A,B);

        System.out.println(max);
    }

    static void find(String A, String B){
        for(int i=1; i<=A.length(); i++){
            for(int j=1; j<=B.length(); j++){
                if(A.charAt(i-1) == B.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = 0;

                max = Math.max(dp[i][j], max);
            }
        }
    }
}