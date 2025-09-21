import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Info> al = new ArrayList<>();
    static int[] parents;
    static long ans;
    static int cnt;
    static int V;
    static int E;

    public static void main(String[] args) throws IOException {
        input();
        sort();
        for(int i = 0; i< al.size(); i++){
            union(al.get(i));
            if(cnt == V-1) break;
        }
        System.out.println(ans);
    }


    static void input()  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = atoi(st.nextToken());
        E = atoi(st.nextToken());

        int std;
        int end;
        int wei;

        parents = new int[V+1];
        Arrays.fill(parents, -1);

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            std = atoi(st.nextToken());
            end = atoi(st.nextToken());
            wei = atoi(st.nextToken());
            al.add(new Info(std, end, wei));
        }
    }

    static void sort(){
        Collections.sort(al, (o1, o2) -> {
            return o1.wei - o2.wei;
        });
    }

    static Integer atoi(String s){
        return Integer.parseInt(s);
    }

    static Integer find(int v){
        if(parents[v] < 0) return v;
        return parents[v] = find(parents[v]); // 경로 압축
    }

    static void union(Info info){
        int u = find(info.st);
        int v = find(info.ed);
        if(u == v) return;
        parents[u] = v;
        ans += info.wei;
        cnt++;
    }

    static class Info{
        int st;
        int ed;
        int wei;

        public Info(int st, int ed, int wei){
            this.st = st;
            this.ed = ed;
            this.wei = wei;
        }
    }
}
