import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N , S;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s=0; int e=0;
        int sum=arr[0];
        boolean flag = false;
        while(s <= e && (e < N)){
            // System.out.println(s + " " + e + " " + sum);
            if(sum >= S){
                flag = true;
                min = Math.min(min, e-s+1);
                sum -= arr[s++];
            }
            else{
                if(e+1 >= N) break;
                sum += arr[++e];
            }
            
        }

        System.out.println((flag) ? min : 0);
        
    }
}