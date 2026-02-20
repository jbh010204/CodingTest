import java.util.*;
import java.lang.*;
import java.io.*;


//산성 - 양수
//알칼리성 - 음수

class Main {
    static long res;
    static int N;
    static Integer[] arr; 
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    

        arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        res = 2000000001;
        int resX = 0; int resY = 0;

        int start = 0; int end = N-1;
        
        while(end > start){
            long sum = (long)arr[start] + arr[end];
            long abs = Math.abs(sum);

            if(abs < res){
                res = abs;
                resX = arr[start];
                resY = arr[end];
            }

            if(sum > 0) end--;
            else start++;
        }

        System.out.println((resX < resY) ? resX + " " + resY : resY + " " + resX);
        
    }
}