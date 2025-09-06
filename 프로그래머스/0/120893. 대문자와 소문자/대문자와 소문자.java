class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) <= 90)
                sb.append(String.valueOf(my_string.charAt(i)).toLowerCase());
            else 
                sb.append(String.valueOf(my_string.charAt(i)).toUpperCase());
        }
        
        return sb.toString();
    }
}