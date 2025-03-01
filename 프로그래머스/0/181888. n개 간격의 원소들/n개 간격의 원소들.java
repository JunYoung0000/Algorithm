class Solution {
    public int[] solution(int[] num_list, int n) {
        int size = num_list.length / n;
        int idx = 0;
        if(num_list.length % n != 0){
            size ++;
        }
        
        int[] answer = new int[size];

        for(int i = 0; i<num_list.length; i+=n){
            answer[idx] = num_list[i];
            idx++;
        }
        return answer;
    }
}