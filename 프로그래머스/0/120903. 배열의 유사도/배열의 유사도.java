class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        for(int i = 0; i < s1.length; i++){
            for(int m = 0; m < s2.length; m++){
                if(s2[m].equals(s1[i])){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}