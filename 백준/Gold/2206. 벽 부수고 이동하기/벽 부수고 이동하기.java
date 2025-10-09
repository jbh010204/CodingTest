
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Gold 3: 벽 부수고 이동하기
 * 이것도 말이 되고픈 원숭이 문제처럼 3차원으로 풀면 되지 않을까
 */
public class Main {
    static int ROW, COL;
    static int[][] gp;
    static boolean visited[][][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        input();
        bfs();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        gp = new int[ROW][COL];
        visited = new boolean[ROW][COL][2];

        for(int i=0; i<ROW; i++){
            String str = br.readLine();
            for(int j=0; j<COL; j++){
                gp[i][j] = str.charAt(j) - '0';
            }
        }
    }

    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        visited[0][0][1] = true;
        q.add(new Node(0,0,1,1));


        while(!q.isEmpty()){
            Node cur = q.poll();

            //System.out.println("X: "+cur.x+" Y: "+cur.y);

            if(cur.x == ROW-1 && cur.y == COL-1){
                System.out.println(cur.dist);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= ROW || ny >= COL) continue;
                if(visited[nx][ny][cur.k]) continue;
                if(gp[nx][ny] == 1) continue;

                visited[nx][ny][cur.k] = true;
                q.add(new Node(nx,ny,cur.k, cur.dist + 1));
            }

            if(cur.k > 0){
                for(int i=0; i<4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    int nk = cur.k -1;

                    if(nx < 0 || ny < 0 || nx >= ROW || ny >= COL) continue;
                    if(visited[nx][ny][nk]) continue;
                    if(gp[nx][ny] != 1) continue;

                    visited[nx][ny][nk] = true;
                    q.add(new Node(nx,ny,nk, cur.dist + 1));
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

        Node(int x, int y, int k, int dist){
            this.x = x;
            this.y = y;
            this.k = k;
            this.dist = dist;
        }
    }
}
