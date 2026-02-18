import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    //0 40 -> 5 10 -> 15 30
    static int N;
    static class Data implements Comparable<Data>{
        int s; int e;

        public Data(int s, int e){ this.s=s; this.e=e;}

        @Override
        public int compareTo(Data o){
            if(this.s != o.s) return Integer.compare(this.s, o.s);
            else return Integer.compare(this.e, o.e);
        }
    }
    
    public static void main(String[] args) throws IOException {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        PriorityQueue<Integer> room = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //입력
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Data(s,e));
        }
        
        while(!pq.isEmpty()){
            Data d = pq.poll();
                
            if(!room.isEmpty() && room.peek() <= d.s) {
                room.poll();
            } 
            room.add(d.e);
        }

        System.out.println(room.size());
    }
}