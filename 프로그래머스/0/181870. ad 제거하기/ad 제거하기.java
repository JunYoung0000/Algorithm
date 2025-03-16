import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> result = new ArrayList<>();

        for (String s : strArr) {
            if (!s.contains("ad")) {
                result.add(s);
            }
        }

        return result.toArray(new String[0]);
    }
}
