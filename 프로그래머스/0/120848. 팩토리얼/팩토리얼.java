class Solution {
    public int solution(int n) {
        int answer = 1;
        int temp = 1;
        int value = 1;
        
        while(true){
            int i = 1;
            value = 1;
            
            for(i = 1; i <= answer; i++){
                value *= i;
            }
            
            if(value <= n && value >= 0){
                temp = i - 1;
                answer++;
            } else {
                return temp;
            }
        }
    }
}