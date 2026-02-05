import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ArrayList<Score> arr = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int k =  Integer.parseInt(st.nextToken());
            int e =  Integer.parseInt(st.nextToken());
            int m =  Integer.parseInt(st.nextToken());

            arr.add(new Score(name, k, e, m));
        }

        Collections.sort(arr, new ScoreComparator());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< arr.size(); i++){
            sb.append(arr.get(i).name).append("\n");
        }
        System.out.println(sb);
    }

    static class Score{
        String name;
        int kor;
        int eng;
        int math;

        Score(String name, int kor, int eng, int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    static class ScoreComparator implements Comparator<Score>{
        @Override
        public int compare(Score s1, Score s2){
            if(s1.kor != s2.kor){
                return s2.kor - s1.kor;
            }
            else if(s1.eng != s2.eng){
                return s1.eng - s2.eng;
            }
            else if(s1.math != s2.math){
                return s2.math - s1.math;
            }

            return s1.name.compareTo(s2.name);
        }
    }
}