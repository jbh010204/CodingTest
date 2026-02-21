import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static class D implements Comparable<D>{
        int x; int y;

        public D(int x, int y){this.x=x; this.y=y;}

        @Override
        public int compareTo(D d){
            return Integer.compare(this.x, d.x);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        List<D> list = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new D(start,end));
        }

        Collections.sort(list);

        for(D d : list){
            int s = d.x;
            int e = d.y;
            
            if(!pq.isEmpty()){
                int t = pq.peek();
                if(t <= s) {
                    pq.poll();
                }
            }
            pq.add(e);
        }

        System.out.println(pq.size());
    }
}