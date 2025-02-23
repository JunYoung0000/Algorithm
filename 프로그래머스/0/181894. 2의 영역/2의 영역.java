import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int idx = 0; idx < arr.length; idx++){
            if(arr[idx] == 2)
                answer.add(idx);
        }
        
        if(answer.size() >= 2){
            int[] answer_arr = new int[answer.get(answer.size()-1)-answer.get(0)+1];
            
            for(int i = 0; i < answer_arr.length; i++){
                answer_arr[i] = arr[answer.get(0)+i];
            }
            return answer_arr;
        }
        else if(answer.size() == 1){
            int[] answer_arr = {2};
            return answer_arr;
        }
        else{
            int[] answer_arr = {-1};
            return answer_arr;
        }
    }
}