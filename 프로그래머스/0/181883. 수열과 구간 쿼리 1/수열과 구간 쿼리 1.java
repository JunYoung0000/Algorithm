class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        
        for(int k = 0; k < arr.length; k++){
            answer[k] = arr[k];
        }
        
        for(int i = 0; i < queries.length; i++){
            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                answer[j] += 1;
            }
        }
        return answer;
    }
}