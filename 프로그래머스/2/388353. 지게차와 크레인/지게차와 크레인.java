import java.io.*;
import java.util.*;

// 크레인보다 외부 창고의 유무를 어떻게 파악할 것인가.
// dfs로 시작노드를 박고 외부지점으로 이동가능한지 보면 될듯한데?
class Solution {
    
    static char[][] gp;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int ans;
    static int row;
    static int col;
    static boolean flag;
    
    public int solution(String[] storage, String[] requests) {
        row = storage.length;
        col = storage[0].length();
        gp = new char[row][col];
        visited = new boolean[row][col];
        ans = row*col;
        
        for(int i=0; i<row; i++){
            gp[i] = storage[i].toCharArray();
        }
        
        process(requests);
        
                // 확인용 출력
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(gp[i][j] + " ");
            }
            System.out.println();
        }
        

        return ans;
    }
    
    private void process(String[] request){
        for(String req: request){
            char a = req.charAt(0);
            if(req.length() == 1){ // 지게차
                forkLift(a);
            }
            else{
                crain(a);
            }
        }
    }
    
    private void forkLift(char container){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(gp[i][j] == container){
                    init();
                    if(dfs(i,j)) q.offer(new int[]{i,j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            gp[tmp[0]][tmp[1]] = '.';
            ans--;
        }
    }
    
    private void crain(char container){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(gp[i][j] == container){
                    gp[i][j] = '.';
                    ans--;
                }
            }
        }
    }
    
    private boolean dfs(int x, int y){
        visited[x][y] = true;
        if(x == 0 && 0 <= y && y < col) flag = true; //상
        if(x == row-1 && 0 <= y && y < col) flag = true; //하
        if(y == 0 && 0 <= x && x < row) flag = true; //좌
        if(y == col-1 && 0 <= x && x < row) flag = true; //우
        
        if(flag){
            return flag;
        }
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
            if(visited[nx][ny]) continue;
            if(gp[nx][ny] != '.') continue;
            
            dfs(nx,ny);
        }
        return flag;
    }
    
    private void init(){
        for(int i=0; i<row; i++){
            flag = false;
            Arrays.fill(visited[i], false);
        }
    }    
}
    