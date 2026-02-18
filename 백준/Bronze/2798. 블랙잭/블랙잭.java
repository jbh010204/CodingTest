import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N,M;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, arr, 0, 0);
        System.out.println(max);
    }

    //조합
    static void dfs(int depth, int[] arr, int sum, int index){
        if(depth == 3){
            if(isMax(sum)) max = sum;
            return;
        }

        for(int i = index; i<arr.length; i++){
            dfs(depth + 1, arr, sum + arr[i], i + 1);
        }
    }

    static boolean isMax(int num){
        if(num <= M && (Math.max(num, max) == num)) return true;
        return false;
    }
}