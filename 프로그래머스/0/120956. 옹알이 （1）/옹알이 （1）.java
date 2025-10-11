class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for (String babble : babbling) {
            String currentBabbling = babble;

            for (String word : words) {
                currentBabbling = currentBabbling.replace(word, " ");
            }
            
            currentBabbling = currentBabbling.replace(" ", "");
            
            if (currentBabbling.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}