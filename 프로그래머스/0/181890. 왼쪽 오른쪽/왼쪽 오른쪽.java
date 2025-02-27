class Solution {
    public String[] solution(String[] str_list) {
        for(int i = 0; i < str_list.length; i++){
            if(str_list[i].equals("l")){
                String[] answer = new String[i];
                for(int m = 0; m < i; m++){
                    answer[m] = str_list[m];
                }
                return answer;
            }
            else if(str_list[i].equals("r")){
                String[] answer = new String[str_list.length - (i + 1)];
                for(int m = 0; m < str_list.length - (i+1); m++){
                    answer[m] = str_list[i + 1 + m];
                }
                return answer;
            }
        }
        return new String[] {};
    }
}