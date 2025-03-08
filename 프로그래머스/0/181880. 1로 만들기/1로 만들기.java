class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int changes;

        while ((changes = toOne(num_list)) != 0) { 
            answer += changes;
        }

        return answer;
    }
    
    private int toOne(int[] num_list){
        int num = 0;
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] != 1){
                if(num_list[i] % 2 == 0){
                    num_list[i] = num_list[i] / 2;
                }
                else {
                    num_list[i] = (num_list[i] -1) /2;
                }
                num ++;
            }
        }
        return num;
    }
}