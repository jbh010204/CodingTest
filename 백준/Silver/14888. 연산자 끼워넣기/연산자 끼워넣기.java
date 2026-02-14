import java.util.*;
import java.lang.*;
import java.io.*;

// 순열: DFS + 백트래킹(visited)
class Main {
    static int N, max, min;
    static int[] nums;
    static char[] ops;
    static char[] tmp = {'+', '-', '*', '%'};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        max = -1000000000; min = 1000000000;
        nums = new int[N];
        ops = new char[N-1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        
        for(int i=0; i<4; i++){
            int t = Integer.parseInt(st.nextToken());
            while(t > 0){
                ops[idx++] = tmp[i];
                t--;
            }
        }

        // 로직
        char[] outs = new char[N-1];
        boolean[] visited = new boolean[N-1];
        dfs(ops, outs, 0, visited);

        System.out.println(max);
        System.out.println(min);
        
    }

    static void dfs(char[] arr, char[] outs, int depth, boolean[] visited){
        if(depth == N-1){
            max = Math.max(max, calculate(nums, outs));
            min = Math.min(min, calculate(nums, outs));

            return;
        }

        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                outs[depth] = arr[i];
                dfs(arr, outs, depth + 1, visited);
                visited[i] = false;
            }
        }
        
    }

    static int calculate(int[] nums, char[] ops){
        int n1 = nums[0];
        for(int i=0; i<ops.length; i++){
            char op = ops[i];
            switch(op){
                case '+':
                    n1 += nums[i+1];
                    break;
                case '-':
                    n1 -= nums[i+1];
                    break;
                case '*':
                    n1 *= nums[i+1];
                    break;
                case '%':
                    n1 /= nums[i+1];
                    break;
            }
        }

        return n1;
    }
}
