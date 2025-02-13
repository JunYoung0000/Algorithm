class Solution {
    public String solution(String my_string, int m, int c) {
        String [][]answer = new String[my_string.length()/m][m];
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0;  i <  my_string.length()/m; i++){
            for(int o = 0; o < m; o++){
                answer[i][o] = String.valueOf(my_string.charAt(index));
                index++;
            }
        }
        
        for( int a = 0; a < my_string.length()/m; a++){
            sb.append(answer[a][c-1]);
        }
        
        return sb.toString();
    }
}