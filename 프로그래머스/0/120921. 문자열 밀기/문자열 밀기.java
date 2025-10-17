class Solution {
    public int solution(String A, String B) {
        if(B.equals(A)) {
            return 0;
        }
        
        int answer = 0;
        
        for(int i = 0; i < B.length() - 1; i++){
            answer++;
            StringBuilder sb = new StringBuilder();
            
            sb.append(A.charAt(A.length() - 1));
            
            for(int m = 0; m < A.length() - 1; m++){
                sb.append(A.charAt(m));
            }
            
            if(sb.toString().equals(B)){
                return answer;
            } else {
                A = sb.toString();
            }
        }
        
        return -1;
    }
}