class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int idx_before_delete = arr.length;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < delete_list.length; j++){
                if(arr[i] == delete_list[j]){
                    arr[i] = 0;
                }
            }
        }
        
        int idx_after_delete = arr.length;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                idx_after_delete--;
            }
        }
        
        int[] answer = new int[idx_after_delete];
        int idx = 0;
        for(int i = 0; i < idx_before_delete; i++){
            if(arr[i] != 0){
                answer[idx] = arr[i];
                idx++;
            }
        }
        return answer;
    }
}