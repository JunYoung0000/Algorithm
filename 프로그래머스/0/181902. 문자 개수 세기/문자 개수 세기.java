class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for(int i = 0; i < 52; i++){
            answer[i] = 0;
        }
        
        for(int m = 0; m < my_string.length(); m++){
            if(my_string.charAt(m) >= 'a'){
                answer[Integer.valueOf(my_string.charAt(m) - 71)] += 1;
            }
            else
                answer[Integer.valueOf(my_string.charAt(m) - 'A')] += 1;
        }
        
        return answer;
    }
}