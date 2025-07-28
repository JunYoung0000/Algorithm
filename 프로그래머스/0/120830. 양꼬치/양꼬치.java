class Solution {
    public int solution(int n, int k) {
        int real_k = k - (n/10);
        int total = n * 12000 + real_k * 2000;
        return total;
    }
}