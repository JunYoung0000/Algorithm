class Solution {
    public int solution(String my_string, String is_prefix) {
        for(int i = my_string.length(); i > 0; i--){
            if(my_string.substring(0, i).equals(is_prefix))
                return 1;
        }
        
        return 0;
    }
}