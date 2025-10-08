
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int TC;
    static int N,M,W;
    static long[] dist;
    static ArrayList<ArrayList<Edge>> adj;
    static Long INF = Long.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        input();
    }


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TC = Integer.parseInt(st.nextToken());

        for(int i=0; i<TC; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //정점
            M = Integer.parseInt(st.nextToken()); //간선
            W = Integer.parseInt(st.nextToken()); //웜홀

            dist = new long[N+1];
            Arrays.fill(dist, INF);

            //adj 초기화
            adj = new ArrayList<ArrayList<Edge>>();
            for(int k=0; k<N+1; k++){
                adj.add(new ArrayList<Edge>());
            }

            for(int j=0; j<M; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                adj.get(start).add(new Edge(end, cost));
                adj.get(end).add(new Edge(start, cost));
            }

            //웜홀 입력
            for(int k=0; k<W; k++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                adj.get(start).add(new Edge(end, -cost));
            }

            process();
        }
    }

    static void process(){
        for(int i=1; i<=N; i++){
            if(bellman(i)){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    static boolean bellman(int start){
        dist[start] = 0;

        for(int i=0; i<N; i++){
            boolean updated = false;
            for(int j=1; j<=N; j++){
                for(Edge edge: adj.get(j)){
                    int curr = j;
                    int next = edge.idx;
                    int cost = edge.cost;
                    if(dist[curr] != INF && (dist[next] > dist[curr] + cost)){
                        dist[next] = dist[curr] + cost;
                        updated = true;
                        if(i == N-1) return true;
                    }
                }
            }
            if(!updated) break;
        }
        return false;
    }

    static class Edge{
        int idx;
        int cost;
        public Edge(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
}
