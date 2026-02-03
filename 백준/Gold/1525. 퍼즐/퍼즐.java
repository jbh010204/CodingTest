import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
        static int[] dr = {-1, 1, 0, 0};
        static int[] dc = {0,0, -1, 1};

    // 그래프 달라지는 건 어떻게? 123456780
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        String firstStr = "";
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            firstStr += st.nextToken();
            firstStr += st.nextToken();
            firstStr += st.nextToken();
        }

        Map<String, Integer> map = new HashMap<>();
        Deque<String> dq = new ArrayDeque<>();
        dq.offer(firstStr);
        map.put(firstStr, 0);

        while(!dq.isEmpty()){
            String curr = dq.poll();
            int dist = map.get(curr);

            if(curr.equals("123456780")){
                System.out.println(dist);
                return;  
            } 

            int zeroIdx = curr.indexOf("0");
            int r = zeroIdx / 3;
            int c = zeroIdx % 3;
            
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(0 <= nr && nr <= 2 && 0 <= nc && nc <=2){
                    int newZeroIdx = nr * 3 + nc;

                    String next = swap(curr, zeroIdx, newZeroIdx);

                    if(!map.containsKey(next)){
                        map.put(next, dist + 1);
                        dq.offer(next);
                    }
                }
            }
        }

        System.out.println(-1);
        return;
    }

    static String swap(String str, int i, int j){
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}