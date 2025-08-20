class Solution {
    public int solution(int[] numbers, int k) {
        int index = 0;
        
        for(int i = 0; i < k - 1; i++){
            index += 2;
            if(numbers.length <= index){
                index = index - numbers.length;
            }
        }
        
        int answer = numbers[index];
        
        return answer;
    }
}