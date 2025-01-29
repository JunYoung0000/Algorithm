import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int m = 0; m < queries.length; m++) {
            Integer min = null;

            for (int i = queries[m][0]; i <= queries[m][1]; i++) {
                if (arr[i] > queries[m][2]) {
                    if (min == null) {
                        min = arr[i];
                    } else if (min > arr[i]) { 
                        min = arr[i];
                    }
                }
            }

            if (min == null) {
                answer.add(-1);
            } else
                answer.add(min);
        }
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;

    }
}