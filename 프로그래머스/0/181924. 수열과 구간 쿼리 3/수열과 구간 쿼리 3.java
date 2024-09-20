class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr.clone();
        
        for(int i = 0; i<queries.length; i++){
            int index1 = queries[i][0];
            int index2 = queries[i][1];
            

            int temp = answer[index1];
            answer[index1] = answer[index2];
            answer[index2] = temp;

        }
        return answer;
    }
}