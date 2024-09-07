class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int ab = Integer.parseInt(Integer.toString(a)+ Integer.toString(b));
        int ba = Integer.parseInt(Integer.toString(b)+ Integer.toString(a));
        
        if (ab > ba){
            answer = ab;
        }
        else
            answer = ba;
        return answer;
    }
}