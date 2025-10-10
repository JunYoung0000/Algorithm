class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            // i번째 학생의 평균 점수
            double avg = (score[i][0] + score[i][1]) / 2.0;
            int rank = 1; // 1등에서 시작

            // 다른 학생과 비교
            for (int j = 0; j < n; j++) {
                double otherAvg = (score[j][0] + score[j][1]) / 2.0;
                if (otherAvg > avg) {
                    rank++; // 나보다 높은 평균이 있으면 등수 증가
                }
            }

            answer[i] = rank; // 등수 저장
        }

        return answer;
    }
}
