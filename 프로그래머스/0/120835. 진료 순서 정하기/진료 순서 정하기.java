import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] copy = new int[emergency.length];
        
        for(int i = 0; i < emergency.length; i++){
            copy[i] = emergency[i];
        }
        
        Arrays.sort(copy);
        
        int[] reversed = new int[copy.length];
        for (int i = 0; i < copy.length; i++) {
            reversed[i] = copy[copy.length - 1 - i];
        }
        
        for(int i = 0; i<emergency.length; i++){
            for(int m = 0; m < emergency.length; m++){
                if(reversed[i] == emergency[m]){
                    answer[m] = i + 1;
                }
            }
        }
        
        return answer;
    }
}