import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Platinum 5: 오민식의 고민
 * 벨만인데 신경쓸게 많은듯한
 */
public class Main {
    static int N, start, end, edge;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] money;
    static long[] dist;
    static long INF = (Long.MAX_VALUE / 2) * (-1);

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        money = new int[N];
        dist = new long[N];
        Arrays.fill(dist, INF);

        for(int i=0; i<edge; i++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost =  Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, cost));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            money[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void process(){
        boolean flag = bellman(start);

        if(dist[end] == INF){
            System.out.println("gg");
            return;
        }

        if(flag){
            System.out.println("Gee");
        }
        else{
            System.out.println(dist[end]);
        }
    }

    static boolean bellman(int start) {
        dist[start] = money[start];
        boolean[] cycle = new boolean[N]; // 양수 사이클 포함 노드 표시

        for (int i = 0; i < N; i++) {
            for (Edge e : edges) {
                int curr = e.from;
                int next = e.to;
                int cost = e.cost;
                long nextVal = dist[curr] + money[next] - cost;

                if (dist[curr] != INF && dist[next] < nextVal) {
                    dist[next] = nextVal;
                    if (i == N - 1) cycle[next] = true;
                }
            }
        }

        // 양수 사이클에서 end로 갈 수 있는가?
        for (int i = 0; i < N; i++) {
            if (cycle[i] && canReach(i)) {
                return true;
            }
        }
        return false;
    }

    static boolean canReach(int s) {
        boolean[] visited = new boolean[N];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == end) return true;
            for (Edge e : edges) {
                if (e.from == curr && !visited[e.to]) {
                    visited[e.to] = true;
                    q.add(e.to);
                }
            }
        }
        return false;
    }

    static class Edge{
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
