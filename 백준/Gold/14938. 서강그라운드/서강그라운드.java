import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Gold 4: 서강 그라운드
 * 접근 방법
 * - 각 노드들을 시작 노드로 지정하여, 갈 수 있는 거리 판단 분기점을 추가
 * - 양방향임(중복이 없게끔 판단)
 */
public class Main {
    static int n,m,r; // 수색 범위:m, 길의 개수: r
    static int maxItem = 0;
    static int currItem = 0;
    static ArrayList<ArrayList<Node>> gp = new ArrayList<ArrayList<Node>>();
    static int[] dist;
    static int[] item;

    static class Node{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        init();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //노드 개수
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());


        //그래프 초기화
        for(int i=0; i<n+1; i++){
            gp.add(new ArrayList<>());
        }

        //dist, item 초기화
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        item = new int[n+1];

        //item 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        //Node 입력
        int a,b,cost;
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            a =  Integer.parseInt(st.nextToken());
            b =  Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            gp.get(a).add(new Node(b, cost));
            gp.get(b).add(new Node(a, cost));
        }

    }

    private static void init(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost, o2.cost));

        for(int i=1; i<n+1; i++){
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0; currItem = 0;
            pq.add(new Node(i, 0));
            process(pq);
        }

        System.out.println(maxItem);
    }

    private static void process(PriorityQueue<Node> pq){
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(dist[node.idx] < node.cost){ //중복 노드 방지
                continue;
            }
            currItem += item[node.idx];

            for(int i=0; i<gp.get(node.idx).size(); i++){
                Node next = gp.get(node.idx).get(i);
                int currCost = dist[node.idx] + next.cost;
                if((dist[next.idx] > currCost) && currCost <= m){
                    dist[next.idx] = dist[node.idx] + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        if(maxItem < currItem){
            maxItem = currItem;
        }
    }


}
