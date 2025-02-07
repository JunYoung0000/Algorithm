import java.util.*;

class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_strings.length; i++){
            for(int m = parts[i][0]; m <= parts[i][1]; m++){
                sb.append(my_strings[i].charAt(m));
            }
        }
        
        return sb.toString();
    }
}