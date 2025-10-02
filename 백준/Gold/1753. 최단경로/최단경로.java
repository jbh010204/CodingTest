
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V,E, start; // 정점, 간선, 시작지점을 받음
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    static class Node{
        int idx;
        int cost;
        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        //Input 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        for(int i=0; i<V+1; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e,c));
            //무향 그래프라면 end에도 연결!
        }

        int[] dist = new int[V+1];
        for(int i=0; i<V+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        //시작정점으로
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            // cur 주변 인접 노드들 탐색
            if(dist[cur.idx] < cur.cost) {
                continue;
            }

            for(int i=0; i<graph.get(cur.idx).size(); i++){
                Node nextNode = graph.get(cur.idx).get(i);
                if(dist[nextNode.idx] > cur.cost + nextNode.cost){
                    dist[nextNode.idx] = cur.cost + nextNode.cost;
                    pq.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }
        toArray(dist);
    }

    private static void toArray(int[] dist){
        for(int i=1; i<V+1; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(dist[i]);
            }
        }
    }

}


