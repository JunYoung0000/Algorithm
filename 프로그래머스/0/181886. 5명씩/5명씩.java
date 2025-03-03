class Solution {
    public String[] solution(String[] names) {
        int size = names.length / 5;
        if(names.length % 5 != 0){
            size ++;
        }
        
        String[] answer = new String[size];
        
        for(int i = 0; i<size; i++){
            answer[i] = names[i*5];
        }
        
        return answer;
    }
}