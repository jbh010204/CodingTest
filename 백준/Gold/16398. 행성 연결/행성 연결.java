import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 접근 방법
 * 1. 그래프에 저장하고, 오름차순 정렬
 * 2. Union-Find로 사이클 판별
 * 3. N-1개의 간선이 선택될 떄까지 반복
 */
public class Main {
    static int N;
    static ArrayList<Graph> al = new ArrayList<>();
    static int[] parents;
    static long ans;
    static int cnt;

    public static void main(String[] args) throws IOException {
        input();

        Collections.sort(al, (o1, o2) -> {
            return o1.wei -  o2.wei;
        });

        for(int i = 0; i < al.size(); i++){
            Graph g = al.get(i);
            union(g);
            if(cnt == N-1) break;
        }

        System.out.println(ans);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        parents = new int[N + 1];
        Arrays.fill(parents, -1);
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k=0; k< i; k++) st.nextToken();
            for(int j=i; j<N; j++){
                int wei = atoi(st.nextToken());
                al.add(new Graph(i,j,wei));
            }
        }
    }

    static Integer atoi(String s){
        return Integer.parseInt(s);
    }

    static int find(int v){
        if(parents[v] < 0) return v;
        return parents[v] = find(parents[v]);
    }

    static void union(Graph g){
        int u = find(g.st);
        int v = find(g.ed);
        if(u == v) return;
        parents[v] = u;
        ans += g.wei;
        cnt ++;
    }

    static class Graph {
        int st;
        int ed;
        int wei;

        public Graph(int st, int ed, int wei) {
            this.st = st;
            this.ed = ed;
            this.wei = wei;
        }
    }
}
