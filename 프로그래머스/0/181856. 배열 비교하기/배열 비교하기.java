class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int a = 0;
        int b = 0;
        int answer = 0;        
        if(arr1.length > arr2.length){
            answer = 1;
        }
        else if(arr1.length < arr2.length){
            answer = -1;
        }
        else{
            for(int num : arr1){
                a += num;
            }
            for(int num2 : arr2){
                b += num2;
            }
            if(a > b){
               answer = 1; 
            }
            else if(a < b){
                answer = -1;
            }
            else{
                answer = 0;
            }
        }

        return answer;
    }
}