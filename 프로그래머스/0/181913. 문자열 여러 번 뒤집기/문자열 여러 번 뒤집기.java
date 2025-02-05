class Solution {
    public String solution(String my_string, int[][] queries) {
        String []answer= my_string.split("");
        for(int m = 0; m<queries.length; m++){
            int a = queries[m][0];
            int b = queries[m][1];
            String temp;
            for(; a<b; a++, b--){
                temp = answer[a];
                answer[a] = answer[b];
                answer[b] = temp;
            }
        }
        return String.join("", answer);
    }
}