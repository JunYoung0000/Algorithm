class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int ab = Integer.parseInt(Integer.toString(a)+Integer.toString(b));
        int ab2 = 2 * a * b;
        
        answer = ab > ab2 ? ab : ab2;
        return answer;
    }
}