import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int ROW, COL;
    static boolean visited[][][]; //K를 위해서 3차원
    static int[][] gp;

    static int[] dx  = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] horseX  = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] horseY = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        input();
        bfs();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        COL = Integer.parseInt(st.nextToken());
        ROW = Integer.parseInt(st.nextToken());

        visited = new boolean[ROW][COL][K+1];
        gp = new int[ROW][COL];

        for(int i = 0; i < ROW; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < COL; j++){
                gp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        visited[0][0][K] = true;
        q.add(new Node(0,0, K,0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x == ROW-1 && cur.y == COL-1){
                System.out.println(cur.dist);
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nk = cur.k;
                int nDist = cur.dist + 1;

                if(nx < 0 || ny < 0 || nx >= ROW || ny >= COL) continue;
                if(visited[nx][ny][nk]) continue;
                if(gp[nx][ny] == 1) continue;

                visited[nx][ny][nk] = true;
                q.add(new Node(nx,ny,nk,nDist));
            }

            if(cur.k > 0){
                for(int i = 0; i < 8; i++){
                    int nx = cur.x + horseX[i];
                    int ny = cur.y + horseY[i];
                    int nk = cur.k-1;
                    int nDist = cur.dist + 1;

                    if(nx < 0 || ny < 0 || nx >= ROW || ny >= COL) continue;
                    if(visited[nx][ny][nk]) continue;
                    if(gp[nx][ny] == 1) continue;

                    visited[nx][ny][nk] = true;
                    q.add(new Node(nx,ny,nk,nDist));
                }
            }
        }

        System.out.println(-1);
    }


    static class Node{
        int x;
        int y;
        int k;
        int dist;
        public Node(int x, int y, int k, int dist){
            this.x = x;
            this.y = y;
            this.k = k;
            this.dist = dist;
        }
    }
}
