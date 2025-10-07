class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[201]; // -100 ~ 100 범위를 커버하기 위해 201칸

        for (int[] line : lines) {
            int start = line[0] + 100; // 음수 좌표 보정
            int end = line[1] + 100;

            for (int i = start; i < end; i++) {
                arr[i]++;
            }
        }

        int answer = 0;
        for (int count : arr) {
            if (count >= 2) answer++;
        }

        return answer;
    }
}