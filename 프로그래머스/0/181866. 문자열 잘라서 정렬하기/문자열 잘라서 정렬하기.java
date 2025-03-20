import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public String[] solution(String myString) {
        String[] temp = myString.split("x");
        ArrayList<String> list = new ArrayList<>();

        for (String str : temp) {
            if (!str.isEmpty()) {
                list.add(str);
            }
        }

        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        Arrays.sort(result);
        return result;
    }
}
