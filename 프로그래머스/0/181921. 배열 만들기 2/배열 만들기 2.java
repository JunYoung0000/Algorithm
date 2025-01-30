import java.util.ArrayList;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for ( int i = l; i <= r; i++){
            if (isValidNumber(i)){
                list.add(i);
            }
        }
        
        if(list.isEmpty()){
            return new int[]{-1};
        }
        
        int [] answer = new int[list.size()];
        for (int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private boolean isValidNumber(int num){
        String str = String.valueOf(num);
        for (char ch : str.toCharArray()){
            if (ch != '0' && ch != '5') {
                return false;
            }
        }
        return true;
    }
}