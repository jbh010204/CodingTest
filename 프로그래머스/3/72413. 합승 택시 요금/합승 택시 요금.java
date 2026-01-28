import java.util.*;

class Solution {
    public int[] dijkstra(int n, int start, ArrayList<ArrayList<Node>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 20000001);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.idx]) continue;
            
            for (Node nxt : graph.get(cur.idx)) {
                if (dist[nxt.idx] > dist[cur.idx] + nxt.cost) {
                    dist[nxt.idx] = dist[cur.idx] + nxt.cost;
                    pq.add(new Node(nxt.idx, dist[nxt.idx]));
                }
            }
        }
        return dist;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int[] fare : fares) {
            graph.get(fare[0]).add(new Node(fare[1], fare[2]));
            graph.get(fare[1]).add(new Node(fare[0], fare[2]));
        }

        int[] distS = dijkstra(n, s, graph);
        int[] distA = dijkstra(n, a, graph);
        int[] distB = dijkstra(n, b, graph);

        int answer = Integer.MAX_VALUE;
        
        // 모든 지점 i를 합승 종료 지점으로 고려 
        for (int i = 1; i <= n; i++) {
            int total = distS[i] + distA[i] + distB[i];
            answer = Math.min(answer, total);
        }

        return answer;
    }

    static class Node {
        int idx, cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}