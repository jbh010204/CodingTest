import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Gold 4: 특정한 최단 경로
 */
public class Main {
    static int N,E,V1, V2;
    static ArrayList<ArrayList<Node>> gp = new ArrayList<>();
    static int[] dist;
    static long ans = -1;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<N+1; i++){
            gp.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost  = Integer.parseInt(st.nextToken());
            gp.get(a).add(new Node(b,cost));
            gp.get(b).add(new Node(a,cost));
        }

        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());
    }

    static void process(){
        int[] c1 = new int[]{1,V1,V2,N};
        int[] c2 = new int[]{1,V2,V1,N};
        long path1 = 0; long path2 = 0;
        for(int i=0; i<3; i++){
            init();
            dijkstra(c1[i]);
            if(dist[c1[i + 1]] == Integer.MAX_VALUE){
                System.out.println(ans);
                return;
            }
            path1 += dist[c1[i + 1]];
        }

        for(int i=0; i<3; i++){
            init();
            dijkstra(c2[i]);
            if(dist[c1[i + 1]] == Integer.MAX_VALUE){
                System.out.println(ans);
                return;
            }
            path2 += dist[c2[i + 1]];
        }

        ans = Math.min(path1,path2);

        System.out.println(ans >= Integer.MAX_VALUE?-1:ans);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost,o2.cost));
        dist[start] = 0;
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(dist[node.idx] < node.cost){
                continue;
            }

            for(int i=0; i<gp.get(node.idx).size(); i++){
                Node next = gp.get(node.idx).get(i);
                if(dist[next.idx] > dist[node.idx] + next.cost){
                    dist[next.idx] = dist[node.idx] + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }

    static void init(){
        Arrays.fill(dist, Integer.MAX_VALUE);
    }

    static class Node{
        int idx;
        int cost;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
}