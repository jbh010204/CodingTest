import java.util.*;

class Solution {
    class Truck{
        int weight;
        int exitTime;
        
        Truck(int weight, int exitTime){
            this.weight = weight;
            this.exitTime = exitTime;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int curTime = 0;
        int curWeight = 0;
        Deque<Truck> bridge = new ArrayDeque<>();
        
        for(int tWeight : truck_weights){
            curTime++;
            
            //1. 시간 지난 트럭들 다 빼기
            while(!bridge.isEmpty() && bridge.peekFirst().exitTime <= curTime){
                curWeight -= bridge.pollFirst().weight;
            }
            
            //2. 무게나 대수 초과시 하나 뺴서 시간 점프
            while(curWeight + tWeight > weight || bridge.size() >= bridge_length){
                Truck leavingTruck = bridge.pollFirst();
                curTime = leavingTruck.exitTime;
                curWeight -= leavingTruck.weight;
            }
            
            curWeight += tWeight;
            bridge.offerLast(new Truck(tWeight, curTime + bridge_length));
    
        }
        
        int lastExitTime = 0;
        if (!bridge.isEmpty()) {
            lastExitTime = bridge.peekLast().exitTime;
        }
        

        return lastExitTime;
    }
}