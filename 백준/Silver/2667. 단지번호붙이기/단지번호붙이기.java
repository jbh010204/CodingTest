import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Node{
        int x, y;
        public Node(int x, int y){this.x=x; this.y=y;}
    }
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static ArrayDeque<Node> dq = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        //입력
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    res.add(bfs(i,j,1));
                }
            }
        }

        Collections.sort(res);
        StringBuilder sb = new StringBuilder();

        sb.append(res.size());
        sb.append('\n');
        
        for(int i=0; i<res.size(); i++){
            sb.append(res.get(i));
            sb.append('\n');
        }
        System.out.println(sb);
        
    }

    static int bfs(int x, int y, int cnt){
        visited[x][y] = true;
        dq.offer(new Node(x,y));
        
        while(!dq.isEmpty()){
            Node n = dq.poll();
            
            for(int i=0; i<4; i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
        
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        
                if(!visited[nx][ny] && arr[nx][ny] == 1){
                    visited[nx][ny] = true;
                    dq.offer(new Node(nx,ny));
                    cnt++;
                }
            }
        
        }
        
        return cnt;
    }
}