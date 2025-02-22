import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < intervals.length; i++){
            for(int m = intervals[i][0]; m <= intervals[i][1]; m++){
                answer.add(arr[m]);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}