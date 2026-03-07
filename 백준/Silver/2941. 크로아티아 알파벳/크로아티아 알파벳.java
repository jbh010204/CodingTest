import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for(String s : alpha){
            if(str.contains(s)) str = str.replace(s, "*");
        }

        System.out.println(str.length());
        
    }
}