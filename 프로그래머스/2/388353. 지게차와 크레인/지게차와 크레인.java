import java.io.*;
import java.util.*;

// 크레인보다 외부 창고의 유무를 어떻게 파악할 것인가.
// dfs로 시작노드를 박고 외부지점으로 이동가능한지 보면 될듯한데?
class Solution {
    
    static char[][] gp;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};
    static int ans;
    static int row, col;
    
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
        
        debugPrint();

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
        
        // 외부와 닿으면 true 반환
        if (x == 0 || y == 0 || x == row - 1 || y == col - 1) return true;
    
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
            if(visited[nx][ny]) continue;
            if(gp[nx][ny] != '.') continue;
            
            if(dfs(nx,ny)) return true;
        }
        return false;
    }
    
    private void init(){
        for(boolean[] arr: visited){
            Arrays.fill(arr, false);
        }
    }
    
    private void debugPrint() {
    for (char[] line : gp) {
        System.out.println(Arrays.toString(line));
    }
}
}
    