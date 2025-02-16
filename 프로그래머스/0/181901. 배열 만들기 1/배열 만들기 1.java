import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int k) {
        ArrayList<Integer> answer_list = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            if(i % k == 0){
                answer_list.add(i);
            }
        }
        
        int[] answer = new int[answer_list.size()];
        for (int i = 0; i < answer_list.size(); i++) {
            answer[i] = answer_list.get(i);
        }
        
        return answer;
    }
}