import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> factors = new TreeSet<>(); // 자동 정렬 + 중복 제거

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 1) { // 마지막 남은 수가 소수일 경우
            factors.add(n);
        }

        return factors.stream().mapToInt(Integer::intValue).toArray();
    }
}
