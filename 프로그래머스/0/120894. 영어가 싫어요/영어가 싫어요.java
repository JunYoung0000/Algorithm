class Solution {
    public long solution(String numbers) {
        String[] words = {
            "zero","one","two","three","four","five","six","seven","eight","nine"
        };
        
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < numbers.length(); i++) {
            char ch = numbers.charAt(i);
            sb.append(ch);

            for (int d = 0; d < 10; d++) {
                if (sb.toString().equals(words[d])) {
                    answer.append(d);
                    sb.setLength(0);
                    break;
                }
            }
        }
        return Long.parseLong(answer.toString());
    }
}
