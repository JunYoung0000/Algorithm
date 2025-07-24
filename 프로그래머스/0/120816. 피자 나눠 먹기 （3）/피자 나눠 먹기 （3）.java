class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        
        while(true){
            if (n > slice){
                n = n-slice;
                answer++;
            } else {
                answer++;
                break;
            }
        }
        return answer;
    }
}