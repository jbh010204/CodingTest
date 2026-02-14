import java.util.*;

class Solution {
    // 어피치 a -> 라이언 b
    // k (1~10) a == b 이면 어피치가 k점 가져감
    // info[11] = [10점 맞힌 개수 ~ 0점 맞힌 개수]
    
//     dfs 중복 순열 
//     -> length 도달하면 calculate 
//         -> max값 갱신 List<> 초기화 후 다시 넣기
//         -> max값 똑같으면 add
        
//     -> process() 가장 낮은 점수에 많이 쏜 사람 비교 
//         -> index역순으로 s1 s2비교 한쪽에만 있으면 그거 리턴 둘 다 있으면 continue;
    static int N;
    static int max = 0;
    static int[] best = new int[11];
        
    public int[] solution(int n, int[] info) {
        max = 0;
        N = n;
        
        int[] out = new int[11];
        Arrays.fill(out, 0); 
        
        dfs(info, out, 0, 0);
        
        if(max == 0) return new int[]{-1};
        
        return best;
    }
    
    void dfs(int[] info, int[] out, int depth, int start){
        if(depth == N){
            calculate(info, out.clone());
            return;
        }
        
        for(int i=start; i<out.length; i++){
            if(info[i] < out[i]) continue;
            
            out[i] += 1;
            dfs(info, out, depth + 1, i);
            out[i] -= 1;    
        }
        return;
    }
    
    void calculate(int[] info, int[] out){
        int lion = 0; int apeach = 0;
        
        for(int i=0; i<info.length; i++){
            int s1 = info[i];
            int s2 = out[i];
            
            if(s1 != 0 || s2 != 0){
                if(s1 < s2) apeach += 10-i;
                else lion += 10-i; 
            }
        }
        
        int diff = apeach - lion;
        if(max == diff && isBetter(out)) best = out.clone();
        else if(max < diff){
            max = diff;
            best = out.clone();
        } 
    }
    
    boolean isBetter(int[] tmp){
        for(int i=10; i>0; i--){
            if(best[i] > tmp[i]) return false;
            if(best[i] < tmp[i]) return true;
        }
        return false;
    }
}