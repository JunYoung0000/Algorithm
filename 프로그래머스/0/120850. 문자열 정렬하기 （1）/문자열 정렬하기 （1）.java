import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        int size = 0;
        
        for (int i = 0; i < my_string.length(); i++) {
            if (Character.isDigit(my_string.charAt(i))) {
                size++;
            }
        }

        int[] answer = new int[size];
        int idx = 0;
        
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (Character.isDigit(c)) {
                answer[idx++] = c - '0';
            }
        }

        Arrays.sort(answer);
        return answer;
    }
}
