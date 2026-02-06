import java.util.*;

class Solution {
    static int[][] arr;
    static int[][] dp;
    static int N;
    public int solution(int[][] triangle) {
        N = triangle.length;
        arr = new int[N][N];
        dp = new int[N][N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<triangle[i].length; j++){
                arr[i][j] = triangle[i][j];
            }
        }
        
        dp[0][0] = arr[0][0];
        if(N==1) return dp[0][0];
        
        for(int i=1; i<N; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j==0) dp[i][j] = dp[i-1][j] + arr[i][j];
                else if(j == N-1) dp[i][j] = dp[i-1][j-1] + arr[i][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1] + arr[i][j], dp[i-1][j] + arr[i][j]);
                }
            }
        }
        

        int maxNum = 0;
        for(int num : dp[N-1]){
            maxNum = Math.max(num, maxNum);
        }
        
        return maxNum;
    }
}

// 7
// 3 8
// 8 1 0
// 2 7 4 4
// 4 5 2 6 5


