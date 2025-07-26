class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++){
            for(int m = 0; m < n; m++){
                sb.append(my_string.charAt(i));
            }
        }
        return sb.toString();
    }
}