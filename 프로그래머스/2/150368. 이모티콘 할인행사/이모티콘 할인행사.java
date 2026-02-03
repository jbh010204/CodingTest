class Solution {
    
    
    static int[] discounts = {40, 30, 20, 10};
    static int max_users = 0;
    static int max_selling = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int depth = emoticons.length;
        int[] picked_dc = new int[depth];
        
        dfs(0, emoticons, users, picked_dc);
        
        int[] answer = {max_users, max_selling};
        return answer;
    }
    
    private void dfs(int depth, int[] emoticons, int[][] users , int[] picked_dc){
        if(depth == emoticons.length){
            calculate(users, emoticons, picked_dc);
            return;
        }
        
        for(int i=0; i<4; i++){
            picked_dc[depth] = discounts[i];
            dfs(depth+1, emoticons, users, picked_dc);
        }
    }
    
    private void calculate(int[][] users, int[] emoticons, int[] picked_dc){
        int curr_users = 0;
        int curr_selling = 0;
        
        for(int[] user : users){
            int user_selling = 0;
            int user_discount = user[0];
            int user_maximum = user[1];
            
            for(int i=0; i<picked_dc.length; i++){
                if(user_discount <= picked_dc[i]){
                    user_selling += emoticons[i] * (100-picked_dc[i]) /100;
                    //System.out.println(user_selling);
                }
            }
            if(user_selling >= user_maximum){ // 이 가격이면 임티플산다
                curr_users +=1;
            } else{
                curr_selling += user_selling;
            }
            
        }
        
        
        if(max_users < curr_users){
            max_users = curr_users;
            max_selling = curr_selling;
        }
        else if(max_users == curr_users && (max_selling < curr_selling)){
            max_selling = curr_selling;
        }
    }
}