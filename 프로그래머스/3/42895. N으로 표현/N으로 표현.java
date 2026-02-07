import java.util.*;

class Solution {
    static List<Set<Integer>> arr;
    
    public int solution(int N, int number) {
        arr = new ArrayList<>();
        
        if(N == number) return 1;
        
        //초기화
        for(int i=0; i<=8; i++){
            arr.add(new HashSet<>());
        }
        
        String nNum = "";
        for(int i=1; i<=8; i++){
            nNum += (char)(N + '0');
            arr.get(i).add(Integer.parseInt(nNum));
        }
        
        for(int i=1; i<=8; i++){ 
            for(int j=1; j<i; j++){
                int k = i-j;
                for(int num1 : arr.get(j)){
                    for(int num2 : arr.get(k)){
                        arr.get(i).add(num1 + num2);
                        arr.get(i).add(num1 - num2);
                        arr.get(i).add(num1 * num2);
                        if(num2 != 0) arr.get(i).add(num1 / num2);
                    }
                }
            }
            if(arr.get(i).contains(number)){
                return i;
            }
        }
        return -1; 
    }
}