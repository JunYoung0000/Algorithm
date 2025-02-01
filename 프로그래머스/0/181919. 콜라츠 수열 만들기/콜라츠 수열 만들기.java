import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int num = n;
        list.add(num);
        while(num != 1){
            if(num % 2 == 0){
                num /= 2;
                list.add(num);
            }
            else if(num % 2 == 1){
                num = 3 * num + 1;
                list.add(num);
            }
        }
        int []answer = new int[list.size()];
        for ( int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}