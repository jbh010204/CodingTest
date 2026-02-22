import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class D implements Comparable<D>{
        int d; int w;
        public D(int d, int w) {this.d=d; this.w=w;}

        @Override
        public int compareTo(D other){
            if(this.d != other.d) return Integer.compare(other.d, this.d);
            else return Integer.compare(other.w, this.w);
        }
    }
    
    static int N;
    static PriorityQueue<D> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> val = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new D(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        int ans = 0;

        for(int day=pq.peek().d; day > 0; day --){

            while(!pq.isEmpty() && day <= pq.peek().d ){
                D d = pq.poll();
                val.offer(d.w);
            }
            // System.out.println("!!");
            if (!val.isEmpty()) ans += val.poll();
        }

        System.out.println(ans);
    }
}