import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int num : numlist){
            list.add(num);
        }
        
        Collections.sort(list, (a,b) -> {
            int distA = Math.abs(a - n);
            int distB = Math.abs(b - n);
            
            if(distA != distB){
                return distA - distB;
            }
            
            return b - a;
        });
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}