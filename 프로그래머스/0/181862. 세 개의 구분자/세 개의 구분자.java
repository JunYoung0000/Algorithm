import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] split = myStr.split("[abc]");

        List<String> filtered = new ArrayList<>();
        for (String s : split) {
            if (!s.isEmpty()) {
                filtered.add(s);
            }
        }

        if (filtered.isEmpty()) {
            return new String[] { "EMPTY" };
        } else {
            return filtered.toArray(new String[0]);
        }
    }
}
