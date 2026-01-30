import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
	    int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++){
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = arr[0];
		dp[0] = arr[0];
		
		for(int i=1; i<arr.length; i++){
		    dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
		    if(dp[i] > max){
		        max = dp[i];
		    }
		}
		
		System.out.println(max);
	}
}