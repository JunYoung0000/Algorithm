import java.util.*;

class Solution {
    public String solution(String my_string, int[] index_list) {
        ArrayList<String> list = new ArrayList<String>();
        
        for(int i : index_list){
            list.add(String.valueOf(my_string.charAt(i)));
        }
        
        return String.join("",list);
    }
}