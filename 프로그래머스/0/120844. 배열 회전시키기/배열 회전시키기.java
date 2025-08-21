class Solution {
    public int[] solution(int[] numbers, String direction) {
        int size = numbers.length;
        int[] answer = new int[size];
        
        switch(direction){
            case("right"):
                answer[0] = numbers[size-1];
                for(int m = 1; m < size; m++){
                    answer[m] = numbers[m-1];
                }
                break;
                
            case("left"):
                for(int i = 1; i < size; i++){
                    answer[i-1] = numbers[i];
                }
                answer[size-1] = numbers[0];
                break;
        }
        
        return answer;
    }
}