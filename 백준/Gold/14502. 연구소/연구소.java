import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int BLOCK = 1;
    static int SPACE = 0;
    static int VIRUS = 2;
    static int[][] map;
    static int[][] tmp;
    static int[] num;
    static int max = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tmp = new int[N][M];
        num = new int[N*M]; 

        for(int i=0; i< N*M; i++){
            num[i] = i;   
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        copy(map, tmp);
        dfs(0,0,new int[3]);
        System.out.println(max);
    }

    static void dfs(int depth, int start, int[] wall){
  
        
        if(depth == 3){
            copy(map, tmp); 
            
            for(int w : wall){
                int x = w/(M);
                int y = w%(M);

                tmp[x][y] = BLOCK;
            }
            //바이러스 퍼지는 지 실험
            int safe = virus(tmp);
            max= Math.max(max, safe);
            return;
        }

        for(int i=start; i<num.length; i++){
            int x = num[i]/(M);
            int y = num[i]%(M);

            if(map[x][y] == SPACE){
                wall[depth] = num[i];
                dfs(depth + 1, i + 1, wall);
            }
        }
    }

    static void copy(int[][] a, int[][] b){
        for(int i=0; i<a.length; i++){
            System.arraycopy(a[i], 0, b[i], 0, a[0].length);
        }
    }

    static int virus(int[][] a){
        boolean flag = false;
        int cnt = 0;
        while(true){
            flag = false; 
            for(int i=0; i<a.length; i++){
                for(int j=0; j<a[i].length; j++){

                    //바이러스이면 퍼지게
                    if(a[i][j] == VIRUS){
                        for(int k=0; k<4; k++){
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if(nx >= 0 && nx < N && ny >= 0 && ny < M && a[nx][ny] == SPACE){
                                a[nx][ny] = VIRUS;
                                flag = true;
                            }
                        }
                    }
                }
            }
            if(!flag) break;
        }

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                if(a[i][j] == SPACE) cnt++;        
            }
        }

        return cnt;
    }
}