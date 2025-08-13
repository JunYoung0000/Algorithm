class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean same = false;

        for (int i = 1; i * i <= n; i++) {
            for (int m = i; m <= n; m++) {
                if (i * m > n) break;
                if (i * m == n) {
                    answer++;
                    if (i == m) same = true;
                }
            }
        }
        return same ? answer * 2 - 1 : answer * 2;
    }
}
