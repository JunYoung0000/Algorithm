class Solution {
    public int[][] solution(int[] num_list, int n) {
        int size = num_list.length % n > 0 ? num_list.length/n + 1 : num_list.length/n;
        int index = 0;
        int[][] answer = new int[size][n];
        
        for(int i = 0; i < size; i++){
            for(int m = 0; m < n; m++){
                answer[i][m] = num_list[index];
                index++;
            }
        }
        
        return answer;
    }
}