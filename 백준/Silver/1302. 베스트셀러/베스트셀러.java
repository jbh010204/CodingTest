import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String k;
        for(int i=0; i<N; i++){
            k = br.readLine();
            map.put(k, map.getOrDefault(k,0) + 1);
        }

        List<String> keyOrder = new ArrayList<>(map.keySet());
        keyOrder.sort((a,b) -> {
            int o1 = map.get(a);
            int o2 = map.get(b);

            if(o2 != o1) return o2 - o1; // val 
            return a.compareTo(b);
        });

        System.out.println(keyOrder.get(0));
        
    }
}