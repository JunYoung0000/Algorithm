class Solution {
    public int solution(int[] array) {
        int arr[] = new int[1000];
        
        for (int num : array){
            arr[num] += 1;
        }
        
        int max = 0;
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
                index = i;
            }
        }
        
        int count = 0;
        for(int num : arr){
            if(num == max)
                count++;
        }
        
        return count == 1 ? index : -1;
    }
}