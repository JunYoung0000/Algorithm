import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] array) {
        int index = array.length / 2;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int num : array){
            arr.add(num);
        }
        
        Collections.sort(arr);
        
        return arr.get(index);
    }
}