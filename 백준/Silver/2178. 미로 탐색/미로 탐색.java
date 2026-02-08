import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static class Node{
        int x,y,cnt;

        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws IOException{

        Deque<Node> dq = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                arr[i][j] = (str.charAt(j) - '0');
            }
        }

        dq.addFirst(new Node(0,0,1));
        visited[0][0] = true;

        while(!dq.isEmpty()){
            Node node = dq.pollFirst();

            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;
            
            if(x == N-1 && y == M-1){
                System.out.println(cnt);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(arr[nx][ny] == 1 && !visited[nx][ny]){
                        dq.add(new Node(nx,ny, cnt + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
            
        }

        return;
    }
}

