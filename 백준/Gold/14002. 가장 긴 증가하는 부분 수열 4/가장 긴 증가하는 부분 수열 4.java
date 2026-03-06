import java.util.*;
import java.lang.*;
import java.io.*;
 
//2차원배열로 

class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());    
        }

        int max = 0;
        for(int i=1; i<=N; i++){
            dp[i] = 1;

            for(int j=1; j<i; j++){
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        //1 2 2 3 3 4
        
        int t = max;
        for(int k=N; k>0; k--){
            if(dp[k] == t){
                t--;
                list.add(arr[k]);
            }
        }

        Collections.reverse(list);
        int[] res = list.stream().mapToInt(i -> i).toArray();

        StringBuilder sb = new StringBuilder();
        for(int r : res){
            sb.append(r);
            sb.append(" ");
        }
        System.out.println(max);
        System.out.println(sb.toString());
    }
}