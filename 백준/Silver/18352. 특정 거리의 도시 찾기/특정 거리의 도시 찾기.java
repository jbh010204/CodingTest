import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Silver 2: 특정 거리의 도시 찾기
 * 접근 방법
 * 그냥 dist에서 K인 애들을 찾으면 되지 않을까?
 */
public class Main {
    static int N,M,K,X; // 노드, 간선, 목표값, 출발노드
    static ArrayList<ArrayList<Node>> gp = new ArrayList<>();
    static int[] dist;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<N+1; i++){
            gp.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gp.get(a).add(new Node(b,1));
        }
    }

    static void process(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost,o2.cost));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        dist[X] = 0;
        pq.add(new Node(X,0));

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

        for(int i = 1; i <= N; i++){
            if(dist[i] == K){
                queue.add(i);
            }
        }
        if(queue.isEmpty()){
            System.out.println(-1);
        }
        else{
            while (!queue.isEmpty()){
                ans = queue.poll();
                System.out.println(ans);
            }
        }

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