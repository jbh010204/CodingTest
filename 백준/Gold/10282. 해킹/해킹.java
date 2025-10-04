import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T, n, d, c;
    static int start, end, cost;
    static int cnt;
    static int[] dist;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //컴퓨터 수
            d = Integer.parseInt(st.nextToken()); //의존성 수
            c = Integer.parseInt(st.nextToken()); //해킹당한 번호 = start

            dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            graph = new ArrayList<>();
            cnt = 0;
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for(int j=0; j<d; j++){
                st = new StringTokenizer(br.readLine());
                end =  Integer.parseInt(st.nextToken());
                start = Integer.parseInt(st.nextToken());
                cost = Integer.parseInt(st.nextToken());
                graph.get(start).add(new Node(end,cost));
            }
            find();
        }


    }

    static void find(){
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        pq.add(new Node(c, 0 ));
        dist[c] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(dist[node.idx] < node.cost){
                continue;
            }

            for(int i=0; i<graph.get(node.idx).size(); i++){
                Node nextNode = graph.get(node.idx).get(i);
                if(dist[nextNode.idx] > dist[node.idx] + nextNode.cost){
                    dist[nextNode.idx] = dist[node.idx] + nextNode.cost;
                    pq.add(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }

        toArray();
    }

    static void toArray(){
        int maxNum = 0;
        int cnt = 0;
        for(int i = 1; i<dist.length; i++){
            if(dist[i] != Integer.MAX_VALUE){
                cnt++;
                if(dist[i] > maxNum){
                    maxNum = dist[i];
                }
            }
        }
        System.out.println(cnt + " " + maxNum);
    }


    static class Node{
        int idx;
        int cost;

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
}
