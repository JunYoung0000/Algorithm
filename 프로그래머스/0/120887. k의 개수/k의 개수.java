class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        Character ch_k = String.valueOf(k).charAt(0);
        
        for(int num = i; num <= j; num++){
            String s = String.valueOf(num);
            for(Character ch : s.toCharArray()){
                if(ch == ch_k) answer ++;
            }
        }
        
        return answer;
    }
}