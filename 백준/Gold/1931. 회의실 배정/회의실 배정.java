import java.util.*;
import java.io.*;

class Main {
    static class Node implements Comparable<Node> {
        int s, e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node other) {
            // 1순위: 종료 시간이 빠른 순
            if (this.e != other.e) return Integer.compare(this.e, other.e);
            // 2순위: 종료 시간이 같다면 시작 시간이 빠른 순 (시작하자마자 끝나는 회의 대비)
            return Integer.compare(this.s, other.s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 1. 종료 시간 기준으로 정렬
        Collections.sort(list);

        int count = 0;
        int lastEndTime = 0;

        for (Node node : list) {
            if (node.s >= lastEndTime) {
                lastEndTime = node.e;
                count++;
            }
        }

        System.out.println(count);
    }
}