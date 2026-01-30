import java.util.*;
import java.io.*;

public class Main
{   
    static List<Integer> lights;
    static int N, M;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    lights = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine()); 
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++){
		    lights.add(Integer.parseInt(st.nextToken()));
		}
		
		int left = 0;
		int right = N;
		int height = N;
		boolean flag = false;
		while(left <= right){
		    int mid = (left + right) / 2;
		    if(canRoll(mid)){
		        height = mid;
		        right = mid - 1;
		    } else{
		        left = mid + 1;
		    }
		
		}
		
		System.out.println(height);
	}
	
	static boolean canRoll(int height){

		    int left = lights.get(0) - height;
		    int right = lights.get(0) + height;
		    if(left - 0 > 0){
		        return false;
		    }
		    
		    if(lights.size() >= 1){
		        for(int i=1; i<lights.size()-1; i++){
		            if((lights.get(i) - height) - (lights.get(i-1) + height) > 0){
		                return false;
		            }
		        }    
		    }
		    
		    right = lights.get(lights.size()-1) + height;
		    if(N - right > 0){
		        return false;
		    }
		    
		 return true;
	}
}