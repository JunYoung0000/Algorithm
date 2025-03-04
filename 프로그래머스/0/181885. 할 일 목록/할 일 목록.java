class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int size = 0;
        int idx = 0;
        
        for(boolean value : finished){
            if(!value){
                size ++;
            }
        }
        
        String[] answer = new String[size];
        
        for(int i = 0; i < finished.length; i++){
            if(!finished[i]){
                answer[idx] = todo_list[i];
                idx ++;
            }
        }
        return answer;
    }
}