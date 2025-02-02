import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        int[] dice = {a, b, c, d};
        for (int num : dice) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        if (countMap.size() == 1) {
            return 1111 * a;
        }

        for (int key : countMap.keySet()) {
            if (countMap.get(key) == 3) {
                int p = key;
                int q = -1;
                for (int otherKey : countMap.keySet()) {
                    if (otherKey != p) q = otherKey;
                }
                return (int) Math.pow(10 * p + q, 2);
            }
        }

        if (countMap.size() == 2) {
            List<Integer> keys = new ArrayList<>(countMap.keySet());
            if (countMap.get(keys.get(0)) == 2 && countMap.get(keys.get(1)) == 2) {
                int p = keys.get(0);
                int q = keys.get(1);
                return (p + q) * Math.abs(p - q);
            }
        }

        if (countMap.size() == 3) {
            int p = -1, q = -1, r = -1;
            for (int key : countMap.keySet()) {
                if (countMap.get(key) == 2) p = key;
                else if (q == -1) q = key;
                else r = key;
            }
            return q * r;
        }

        return Collections.min(countMap.keySet());
    }
}
