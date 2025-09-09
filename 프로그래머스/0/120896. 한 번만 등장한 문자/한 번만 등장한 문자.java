import java.util.*;

class Solution {
    public String solution(String s) {
        HashMap<Character, Integer> h1 = new HashMap<>();
        for (char ch : s.toCharArray()) {
            h1.put(ch, h1.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList<>();
        for (char ch : h1.keySet()) {
            if (h1.get(ch) == 1) {
                list.add(ch);
            }
        }

        Collections.sort(list);

        StringBuilder answer = new StringBuilder();
        for (char ch : list) {
            answer.append(ch);
        }

        return answer.toString();
    }
}
