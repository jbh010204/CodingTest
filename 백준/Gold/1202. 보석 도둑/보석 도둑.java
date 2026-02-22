import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N,K;
    static int M,V;
    
    static class D implements Comparable<D>{
        int w; int p;
        public D(int w, int p){
            this.w=w;
            this.p=p;
        }

        @Override
        public int compareTo(D o){
            if(this.w != o.w) return Integer.compare(this.w, o.w);
            else return Integer.compare(o.p, this.p);            
        }
    }

    static PriorityQueue<D> pq;
    static PriorityQueue<Integer> pq_val;
    static ArrayList<Integer> bags;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        pq_val = new PriorityQueue<>(Collections.reverseOrder());
        bags = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());           
            pq.offer(new D(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        long ans = 0L;
        
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            bags.add(Integer.parseInt(st.nextToken())); 
        }        

        Collections.sort(bags);

        for(int bag : bags){
            while(!pq.isEmpty() && pq.peek().w <= bag){
                D gem = pq.poll();
                pq_val.offer(gem.p);
            }

            if(!pq_val.isEmpty()) ans += (long) pq_val.poll();
        }
        

        System.out.println(ans);
    }
}