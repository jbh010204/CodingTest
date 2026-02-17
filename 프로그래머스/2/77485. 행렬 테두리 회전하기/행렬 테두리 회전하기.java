import java.util.*;

class Solution {
    static class Node{
        int x,y,v;
        
        public Node(int x, int y, int v){
            this.x=x;
            this.y=y;
            this.v=v;
        }
    }
    
    static List<Node> list = new ArrayList<>();
    static int[][] arr;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        //초기화
        arr = new int[rows+1][columns+1];
        int val = 1;
        int[] res = new int[queries.length];
        int resIdx = 0;
        
        for(int i=1; i<=rows; i++){
            for(int j=1; j<= columns; j++){
                arr[i][j] = val++;
            }
        }    
        
        for(int[] q: queries){
            rotate(q, arr);
            int min = 100000;
            
            for(int i=0; i<list.size(); i++){
                Node node = list.get(i);
                min = Math.min(node.v, min);
                arr[node.x][node.y] = node.v;
            }
            
            list.clear();
            res[resIdx++] = min;
        }
        
            
        return res;
    }
    
    static void rotate(int[] q, int[][] arr){
        int ltx = q[0]; int lty = q[1]; // 왼쪽 위
        int rbx = q[2]; int rby = q[3]; // 오른쪽 아래
        int rtx = ltx; int rty = rby; // 오른쪽 위 
        int lbx = rbx; int lby = lty; // 왼쪽 아래
        
        int currX = ltx; int currY = lty;
        
        System.out.println(currX + " " + currY);
        while(currY < rty){
            list.add(new Node(currX, currY+1, arr[currX][currY++]));
        }

        // System.out.println(currX + " " + currY);
        
        while(currX < rbx){
            list.add(new Node(currX + 1, currY, arr[currX++][currY]));
        }
        
        while(currY > lby){
            list.add(new Node(currX, currY-1, arr[currX][currY--]));
        }
        
        while(currX > ltx){
            list.add(new Node(currX-1, currY, arr[currX--][currY]));
        }
        
        // debug(arr);
    }
    
    static public void debug(int[][] a){
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}