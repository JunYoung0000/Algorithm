class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        int num = money/5500;
        int balance = money%5500;
        answer[0] = num;
        answer[1] = balance;
        return answer;
    }
}