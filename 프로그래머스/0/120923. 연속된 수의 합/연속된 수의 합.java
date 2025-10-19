class Solution {
    public int[] solution(int num, int total) {
        int[] arr = new int[num];
        int value = total;
        
        if(total == 0){
            int start = -(num-1)/2;
            for(int i = 0; i < num; i++){
                arr[i] = start + i;
            }     
        } else {
            while(getSum(arr) != total){
                int minus = 0;

                for(int i = num-1; i >= 0; i--){
                    arr[i] = value - minus;
                    minus++;
                }
                value--;
            }
        }
        
        
        
        return arr;
    }
    
    int getSum(int[] arr){
        int sum = 0;
        
        for(int num : arr){
            sum += num;
        }
        
        return sum;
    }
}