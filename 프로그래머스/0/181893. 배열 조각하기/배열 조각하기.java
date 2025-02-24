import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = new ArrayList<>();
        
        for (int value : arr) {
            list.add(value);
        }

        for (int i = 0; i < query.length; i++) {
            int idx = query[i];

            if (i % 2 == 0) { 
                list = list.subList(0, idx + 1);
            } else { 
                list = list.subList(idx, list.size());
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}