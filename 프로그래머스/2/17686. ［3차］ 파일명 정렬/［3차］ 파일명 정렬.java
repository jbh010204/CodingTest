import java.util.*;

class Solution {
    static List<File> list;
    static class File{
        String name;
        String head;
        int number;
        
        public File(String name, String head, int number){
            this.name = name;
            this.head = head;
            this.number = number;
        }
    }
    
    static class Custom implements Comparator<File>{
        @Override
        public int compare(File f1, File f2){
            if(!f1.head.equals(f2.head)) return f1.head.compareTo(f2.head);
            return f1.number - f2.number;
        }
    }
    
    public String[] solution(String[] files) {
        list = new ArrayList<>();
        for(String f: files){
            process(f);
        }
        
        list.sort(new Custom());
        
        List<String> res = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            res.add(list.get(i).name);            
        }
        
        String[] answer = res.toArray(new String[0]);
        
        return answer;
    }
    
    static void process(String file){
        String head = "";
        String number = "";
        for(int i=0; i<file.length(); i++){
            char c = file.charAt(i);
            if(number.length() > 0 && !Character.isDigit(c)){
                break;
            }
            if(number.length() == 0 && !Character.isDigit(c)){
                head += c;
            }
            else if(Character.isDigit(c) && number.length() < 5){
                number += c;
            }
        }
        // System.out.println(head);
        // System.out.println(Integer.parseInt(number));
        list.add(new File(file, head.toLowerCase(), Integer.parseInt(number)));
    }
}