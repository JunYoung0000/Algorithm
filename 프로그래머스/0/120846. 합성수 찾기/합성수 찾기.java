class Solution {
    public int solution(int n) {
        int count = 0;
        
        for (int i = 4; i <= n; i++) {
            boolean exit = false;
            for (int m = 2; m < i && !exit; m++) {
                for (int l = m; l < i; l++) {
                    if (m * l == i) {
                        count++;
                        exit = true;
                        break;
                    }
                }
            }
        }
        
        return count;
    }
}