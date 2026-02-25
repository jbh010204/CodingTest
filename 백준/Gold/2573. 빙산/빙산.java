import java.util.*;
import java.lang.*;
import java.io.*;

// 두 덩어리로 분리 될 때 시간 구하기 - bfs로 cnt 2?
// 녹는 알고리즘 만들어야할듯

class Main {
    static int N,M;
    static int year = 0;
    static int[][] arr;
    static int[][] minus;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean isAllZero = true;
    static class Node{
        int x,y;

        public Node(int x, int y) {this.x=x; this.y=y;}
    }
    
    public static void main(String[] args) throws IOException{
        input();
        
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        minus = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            year++;
            minus();
            if(isAllZero){
                System.out.println(0);
                return;
            }
            if(isBinary()){
                System.out.println(year);
                return;   
            }
            
        }

        
    }

    static void minus(){
        isAllZero = true; 
        for (int i = 0; i < N; i++) {
            Arrays.fill(minus[i], 0);
            Arrays.fill(visited[i], false);
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] != 0) isAllZero = false;
                
                for(int k = 0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                    if(arr[nx][ny] == 0) minus[i][j] += 1;
                    
                }
                
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] < minus[i][j]) arr[i][j] = 0;
                else arr[i][j] -= minus[i][j];
            }
        }
        
    }

    static boolean isBinary(){
        ArrayDeque<Node> dq = new ArrayDeque<>();
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] != 0 && !visited[i][j]){
                    if(cnt > 0) return true;
                    //처음 bfs인경우
                    dq.offer(new Node(i,j));
                    visited[i][j] = true;
                    
                    bfs(dq);
                    cnt++;
                    
                }
            }
        }
        return false;
    }

    static void bfs(ArrayDeque<Node> dq){
        while(!dq.isEmpty()){
            Node curr = dq.pollFirst();

            for(int i=0; i<4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(arr[nx][ny] != 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    dq.offer(new Node(nx,ny));
                }
            }
            
        }
    }

    static void print(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("DEBUG");
    }
}