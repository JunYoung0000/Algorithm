class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i = 1; i < n; i++){
            answer++;
            boolean more = true;
            
            while(more){
                more = false;
                
                if(answer % 3 == 0 || String.valueOf(answer).contains("3")){
                    answer++;
                    more = true;
                }
            }
        }
        return answer;
    }
}