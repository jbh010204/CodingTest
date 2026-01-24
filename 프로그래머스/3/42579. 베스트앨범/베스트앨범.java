// 1. 재생 수가 많은 장르별로 정렬
// 2. 그 안에서 스트리밍 수 내림차순으로 정렬(만약 스트리밍 수가 동률이면 고유 번호(i)가 낮은 순으로 정렬) 
        
// Sol
// Map을 두게 써야할 듯 
// 1. 장르별 총 play 수 계산 Map
// 2. 각 장르별 실제 객체를 넣어서 compareTo 오버라이드

import java.util.*;


class Solution {
            
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        HashMap<String, List<Music>> playMap = new HashMap<>();
            
        for(int i=0; i<genres.length; i++){
            int play = plays[i];
            String gen = genres[i];
            genreMap.put(gen, genreMap.getOrDefault(gen,0) + play);
            playMap.computeIfAbsent(gen, k -> new ArrayList<>()).add(new Music(i, play));
        }
        
        List<String> genreOrder = new ArrayList<>(genreMap.keySet());
        genreOrder.sort((o1,o2) -> genreMap.get(o2) - genreMap.get(o1));
        
        List<Integer> result = new ArrayList<>();
        
        for(String key: genreOrder){
            List<Music> musicList = playMap.get(key);
            Collections.sort(musicList);
            
                        
            for(int i=0; i<musicList.size(); i++){
                if(i > 1) continue;
                result.add(musicList.get(i).id);
             
            }
        }
        
    
        return result.stream().mapToInt(i-> i).toArray();
    }
}

class Music implements Comparable<Music>{
    int id, play;
    
    public Music(int id, int play){
        this.id = id;
        this.play = play;
    }
    
    @Override
    public int compareTo(Music other){
        if(this.play == other.play) return this.id - other.id;
        //재생 수가 다르다면 내림차순
        return other.play - this.play;
    }
}
