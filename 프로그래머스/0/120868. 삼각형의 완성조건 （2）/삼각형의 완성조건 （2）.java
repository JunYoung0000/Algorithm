class Solution {
    public int solution(int[] sides) {
        int max1 = Math.max(sides[0], sides[1]);
        int min1 = Math.min(sides[0], sides[1]);
        int answer = 0;
        
        for(int i = 1; i < max1; i++){
            if(i + min1 > max1){
                answer++;
            }
        }
        
        for(int m = 1; m < max1 + min1; m++){
            if(max1 <= m){
                answer++;
            }
        }
        
        return answer;
    }
}