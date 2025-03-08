import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int[] int_arr = new int[arr.length];
        int answer = 0;
        
        for(int i = 0; i < arr.length; i++){
            int_arr[i] = arr[i];
        }
        
        while(true){
            int[] compare_arr = new int[arr.length];
            
            for(int i = 0; i < arr.length; i++){
                compare_arr[i] = int_arr[i];
            }
            
            for(int i = 0; i < arr.length; i++){
                if(int_arr[i] >= 50 && int_arr[i] % 2 == 0){
                    int_arr[i] /= 2;
                }
                else if(int_arr[i] < 50 && int_arr[i] % 2 != 0){
                    int_arr[i] = int_arr[i] * 2 + 1;
                }
            }
            
            if(Arrays.equals(compare_arr, int_arr)){
                return answer;
            }
            answer ++;
        }
    }
}