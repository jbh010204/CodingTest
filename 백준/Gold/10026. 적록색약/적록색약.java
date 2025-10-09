import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Gold 5: 적록색약
 * visited중에 판단 안된 노드를 기점으로 cnt++ 하면 될 듯
 */
public class Main {
    static int N;
    static int normalAns, blindAns;
    static char[][] gp;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        N = Integer.parseInt(st);

        //초기화
        visited = new boolean[N][N];
        gp = new char[N][N];

        for(int i=0; i<N; i++){
            st = br.readLine();
            for(int j=0; j<N; j++){
                gp[i][j] = st.charAt(j);
            }
        }
    }

    static void process(){

        //정상
        for(int i=0; i<visited.length; i++){
            for(int j=0; j<visited[i].length; j++){
                if(!visited[i][j]){
                    dfs(i,j, gp[i][j]);
                    normalAns++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (gp[i][j] == 'G') gp[i][j] = 'R';
            }
        }

        for(int i=0; i<visited.length; i++){
            for(int j=0; j<visited[i].length; j++){
                if(!visited[i][j]){
                    dfs(i,j, gp[i][j]);
                    blindAns++;
                }
            }
        }

        System.out.println(normalAns + " " + blindAns);
    }

    static void dfs(int x, int y, char color){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(visited[nx][ny]) continue;
            if(gp[nx][ny] != color) continue;

            dfs(nx,ny,color);
        }
    }
}