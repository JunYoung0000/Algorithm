class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n]; // 정답 배열 생성
        int num = 1; // 시작 숫자
        int x = 0, y = 0; // 시작 위치
        int[] dx = {0, 1, 0, -1}; // 행 이동 (오른쪽 → 아래 → 왼쪽 → 위)
        int[] dy = {1, 0, -1, 0}; // 열 이동
        int dir = 0; // 현재 방향 (0:오른쪽, 1:아래, 2:왼쪽, 3:위)

        for (int i = 0; i < n * n; i++) {
            answer[x][y] = num++; // 현재 위치에 숫자 넣기

            // 다음 위치 계산
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 벽을 만나거나 이미 숫자가 채워진 경우 방향 바꾸기
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0) {
                dir = (dir + 1) % 4; // 방향 전환
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        return answer;
    }
}
