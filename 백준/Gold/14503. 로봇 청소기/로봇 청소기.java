import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int r, c, d;
    static int[][] map;
    
    // 북(0), 동(1), 남(2), 서(3) 순서 (문제의 d와 일치)
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }

    public static void solve() {
        int count = 0;

        while (true) {
            // 1. 현재 칸이 청소되지 않은 경우, 현재 칸을 청소한다.
            if (map[r][c] == 0) {
                map[r][c] = 2; // 청소 완료 표시
                count++;
            }

            // 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
            boolean hasEmpty = false;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 0) {
                        hasEmpty = true;
                        break;
                    }
                }
            }

            if (!hasEmpty) {
                // 2. 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                int backD = (d + 2) % 4; // 후진 방향
                int br = r + dr[backD];
                int bc = c + dc[backD];

                // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 후진 (벽이 아니어야 함)
                if (br >= 0 && br < N && bc >= 0 && bc < M && map[br][bc] != 1) {
                    r = br;
                    c = bc;
                } else {
                    // 후진할 수 없다면 작동을 멈춘다.
                    System.out.println(count);
                    return;
                }
            } else {
                // 3. 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                // 반시계 방향으로 90도 회전
                d = (d + 3) % 4;
                
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 바라보는 방향의 앞쪽 칸이 청소되지 않은 빈 칸일 경우 한 칸 전진
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                }
            }
        }
    }
}