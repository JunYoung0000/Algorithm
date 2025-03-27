import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        
        while(i < arr.length){
            if(list.size() == 0){
                list.add(arr[i]);
                i++;
            }
            else if(list.size() > 0 && list.get(list.size()-1) == arr[i]){
                list.remove(list.size()-1);
                i++;
            }
            else if(list.size() > 0 && list.get(list.size()-1) != arr[i]){
                list.add(arr[i]);
                i++;
            }
        }
        
        int[] stk = new int[list.size()];
        for(int j = 0; j < stk.length; j++){
            stk[j] = list.get(j);
        }
        
        return (stk.length == 0) ? new int[]{-1} : stk;
    }
}