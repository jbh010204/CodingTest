import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] gp = new char[12][6];
    static boolean[][] visited = new boolean[12][6];
    static Queue<int[]> q = new LinkedList<>();
    static Queue<Character> moveQ = new LinkedList<>();
    static int ans;
    static boolean flag;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void process(){
        while(true){
            flag = false;

            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    if(gp[i][j] != '.' && !visited[i][j]){
                        init();
                        dfs(i,j,gp[i][j]);
                        if(q.size() >= 4){
                            flag = true;
                            while(!q.isEmpty()){
                                int[] tmp = q.poll();
                                gp[tmp[0]][tmp[1]] = '.';
                            }
                        }
                    }
                }
            }

            if(!flag) break;
            clean();
            ans++;
        }
        System.out.println(ans);
    }

    static void init(){
        q.clear();

        for(int i = 0; i < 12; i++){
            Arrays.fill(visited[i],false);
        }
    }

    static void clean(){

        for(int col = 0; col < 6; col++){
            int currentRow = 11;
            for(int row = 11; row >= 0; row--){
                if(gp[row][col] != '.'){
                    moveQ.offer(gp[row][col]);
                }
            }

            while(!moveQ.isEmpty()){
                gp[currentRow--][col] = moveQ.poll();
            }

            while(currentRow >= 0){
                gp[currentRow--][col] = '.';
            }
        }
    }

    static void dfs(int x, int y, int color){
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
            if(visited[nx][ny]) continue;
            if(gp[nx][ny] != color) continue;
            dfs(nx,ny,color);
        }
    }

    static void print(){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 6; j++){
                System.out.print(gp[i][j] + " ");
            }
            System.out.println();
        }
    }



    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<12; i++){
            String st = br.readLine();
            for(int j=0; j<6; j++){
                gp[i][j] = st.charAt(j);
            }
        }
    }
}
