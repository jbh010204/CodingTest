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

        int s=0;
        int sum=0;
        for(int e=0; e<N; e++){
            sum += arr[e];

            while(sum >= S){
                min = Math.min(min, e-s+1);
                sum -=arr[s++];
            }
        }

        System.out.println((min==Integer.MAX_VALUE) ? 0 : min);
        
    }
    
}