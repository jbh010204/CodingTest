import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Gold 4: 타임머신
 * 음수 가중치가 존재 + 사이클 검출 -> 벨만포드
 */
public class Main {
    static int N; //정점
    static int M; //간선
    static Edge[] e;
    static long[] dist;
    static long INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        e = new Edge[M]; // 간선 초기화
        dist = new long[N+1];
        Arrays.fill(dist,INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            e[i] = new Edge(u,v,c);
        }

    }

    static void process(){
        if(bellman(1)){
            System.out.println(-1);
            return;
        }

        for(int i=2; i<=N; i++){
            if(dist[i] == INF){
                System.out.println(-1);
            }
            else{
                System.out.println(dist[i]);
            }
        }

    }

    static boolean bellman(int start){
        dist[start] = 0;

        for(int i=0; i<N; i++){
            for(Edge edge: e){
                int curr = edge.from;
                int next = edge.to;
                int cost = edge.cost;
                if(dist[curr] != INF && (dist[next] > dist[curr] + cost)){
                    dist[next] = dist[curr] + cost;
                    if(i == N-1) return true;
                }
            }
        }
        return false;
    }

    static class Edge {
        int from;
        int to;
        int cost;
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}