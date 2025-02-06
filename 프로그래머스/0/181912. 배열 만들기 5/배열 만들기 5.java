import java.util.ArrayList;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < intStrs.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = s; j < s + l; j++) {
                sb.append(intStrs[i].charAt(j));
            }

            int num = Integer.parseInt(sb.toString());
            if (num > k) {
                list.add(num);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
