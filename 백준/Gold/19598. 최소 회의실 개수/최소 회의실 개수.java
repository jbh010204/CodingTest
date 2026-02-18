import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    //0 40 -> 5 10 -> 15 30
    static int N;
    static class Data implements Comparable<Data>{
        int s; int e;

        public Data(int s, int e){
            this.s=s;
            this.e=e;
        }

        @Override
        public int compareTo(Data o){
            return this.s - o.s;
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
            boolean flag = false;
            Data d = pq.poll();
        
            if(room.size() == 0){
                room.add(d.e);
                continue;
            }


            int end = room.poll();
            if(d.s < end) {
                room.add(end);
                room.add(d.e);
            } 
            else{
                room.add(d.e);
            }
        }

        System.out.println(room.size());
        
    }
}