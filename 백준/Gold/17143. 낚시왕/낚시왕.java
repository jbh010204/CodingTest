import java.util.*;
import java.lang.*;
import java.io.*;

// 오른쪽으로 한 칸 이동 -> 가장 가까운 상어 없애고
// 상어들 이동 

// 주의 상어는 가장 큰 상어가 살아 남음
// s 속력 d 이동 방향 z 크기
// Map으로 -> 넣고 있으면 크기 비교 업데이트
class Main {
    static int[] dx = {-100,-1,1,0,0};
    static int[] dy = {-100,0,0,1,-1};
    static Map<String, Shark> sharks = new HashMap<>();
    static int R,C,M;
    static int[][] arr;
    static int total = 0;
    
    static class Shark{
        int s;
        int d;
        int z;
        Shark (int s, int d, int z){
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[R+1][C+1];

        if(M == 0){
            System.out.println(M);
            return; 
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            String y = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (d <= 2) s %= ((R - 1) * 2);
            else s %= ((C - 1) * 2);


            sharks.put(x + "/" + y, new Shark(s,d,z));
            arr[Integer.parseInt(x)][Integer.parseInt(y)] = 1;           
        }

        // 낚시왕 인덱스
        int cx = 0; int cy = 1;
        
        for(int i=0; i<C; i++){
            canAdd(cy++);
            move();
        }

        System.out.println(total);
        return;
        
    }

    static void canAdd(int cy){
        for(int i=1; i<=R; i++){
            if(arr[i][cy] == 1){
                String idx = Integer.toString(i) + "/" + Integer.toString(cy);
                Shark s = sharks.get(idx);
                total += s.z;
                //삭제
                sharks.remove(idx);
                arr[i][cy] = 0;

                break;
            }

            
        }
    }

    static public void move(){
        Map<String, Shark> nextSharks = new HashMap<>();

        for(String key : sharks.keySet()){
            Shark sk = sharks.get(key);

            String[] a = key.split("/");
            int cx = Integer.parseInt(a[0]);
            int cy = Integer.parseInt(a[1]);
            
            int speed = sk.s;
            int dir = sk.d;
            int size = sk.z;

            // 기존 위치 지우기 (반복문 내에서 처리)
            arr[cx][cy] = 0;

            int nx = cx;
            int ny = cy;

            for(int i=0; i<speed; i++){
                nx += dx[dir];
                ny += dy[dir];

                if(nx < 1 || nx > R || ny < 1 || ny > C){
                    dir = change(dir);
                    nx += 2*dx[dir];
                    ny += 2*dy[dir];   
                }
            }

            sk.d = dir;

            String newKey = toStr(nx,ny);
            if(nextSharks.containsKey(newKey)){
                Shark tmp = nextSharks.get(newKey);
                if(size > tmp.z) nextSharks.put(newKey, sk);
            } 
            else nextSharks.put(newKey, sk);
        }

        // 1. 모든 이동이 끝난 후 arr를 한 번 더 깨끗하게 비움 (잔상 제거)
        for(int i=1; i<=R; i++) Arrays.fill(arr[i], 0);

        // 2. 최종적으로 살아남은 상어들만 arr에 기록
        sharks = nextSharks;
        for(String key : sharks.keySet()){
            String[] pos = key.split("/");
            arr[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])] = 1;
        }
    }


    static int change(int dir){
        switch(dir){
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
            default: return -1;
        }

    }

    static String toStr(int x, int y){
        return Integer.toString(x) + "/" + Integer.toString(y);
    }
}