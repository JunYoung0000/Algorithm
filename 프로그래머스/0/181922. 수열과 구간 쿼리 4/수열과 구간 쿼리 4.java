class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int []answer = arr.clone();
        int length = arr.length;
        for(int m = 0; m < queries.length; m++){
            for(int i = queries[m][0]; i <= queries[m][1]; i++){
                if(i % queries[m][2] == 0){
                        answer[i] += 1;
                }
            }
        }
        return answer;
    }
}