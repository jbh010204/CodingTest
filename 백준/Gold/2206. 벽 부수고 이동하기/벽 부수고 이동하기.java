import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N,M;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int SPACE = 0;
    static int WALL = 1;
    static ArrayDeque<Node> dq = new ArrayDeque<>();
    static class Node{
        int x; int y; int dist; int broke;
        public Node(int x, int y, int dist, int broke){
            this.x=x; 
            this.y=y;
            this.dist=dist;
            this.broke=broke;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        visited[0][0][1] = true;
        dq.offer(new Node(0,0,1,0));
        System.out.println(bfs());
        
    }

    static int bfs(){
        while(!dq.isEmpty()){
            Node curr = dq.pollFirst();

            if(curr.x == N-1 & curr.y == M-1) return curr.dist;

            for(int i=0; i<4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(arr[nx][ny] == SPACE && !visited[nx][ny][curr.broke]){
                    visited[nx][ny][curr.broke] = true;
                    dq.offer(new Node(nx,ny, curr.dist + 1, curr.broke));
                }
                else if(arr[nx][ny] == WALL){
                    if(curr.broke < 1 && !visited[nx][ny][curr.broke + 1]){
                        visited[nx][ny][curr.broke + 1] = true;
                        dq.offer(new Node(nx,ny, curr.dist + 1, curr.broke + 1));    
                    }
                }
                
            }
        }
        return -1;
    }
}