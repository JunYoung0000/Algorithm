import java.util.*;

class Solution {
    public int solution(int[] array, int height) {        
        Arrays.sort(array);
        
        for(int i = 0; i < array.length; i++){
            if(height < array[i]){
                return array.length - i;
            }
        }
        return 0;
    }
}