import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드의 크기 입력 (N x N 보드)
        int N = Integer.parseInt(br.readLine().trim());

        // 사과의 개수 입력
        int K = Integer.parseInt(br.readLine().trim());

        // 사과가 있는지 여부를 저장하는 배열
        boolean[][] apple = new boolean[N + 1][N + 1];

        // 사과 위치 입력
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            apple[r][c] = true;   // 해당 위치에 사과가 있음
        }

        // 방향 변환 횟수 입력
        int L = Integer.parseInt(br.readLine().trim());

        // 특정 시간에 어떤 방향으로 회전할지 저장
        Map<Integer, Character> turns = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            turns.put(X, C);
        }

        // 방향을 나타내는 배열 (0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위)
        int[] dr = {0, 1, 0, -1};   // 행 증가량
        int[] dc = {1, 0, -1, 0};   // 열 증가량
        int dir = 0;                // 처음 방향은 오른쪽

        // 뱀의 몸이 차지하고 있는 칸을 표시하는 배열
        boolean[][] occupied = new boolean[N + 1][N + 1];

        // 뱀의 몸을 저장하는 Deque (앞이 머리, 뒤가 꼬리)
        Deque<int[]> snake = new ArrayDeque<>();
        snake.addFirst(new int[]{1, 1});   // 뱀 시작 위치
        occupied[1][1] = true;             // 해당 위치를 뱀이 차지함

        int time = 0;   // 시간 카운트

        // 게임 루프 시작
        while (true) {
            time++; // 1초 경과

            // 현재 머리 위치 가져오기
            int[] head = snake.peekFirst();
            int nr = head[0] + dr[dir];   // 다음 이동할 행
            int nc = head[1] + dc[dir];   // 다음 이동할 열

            // ① 벽과 충돌하는지 체크
            if (nr < 1 || nr > N || nc < 1 || nc > N) {
                System.out.println(time);
                return;
            }

            // ② 자기 몸과 충돌하는지 체크
            if (occupied[nr][nc]) {
                System.out.println(time);
                return;
            }

            // ③ 머리를 새로운 위치로 이동 (몸길이 1 증가)
            snake.addFirst(new int[]{nr, nc});
            occupied[nr][nc] = true;

            // ④ 이동한 칸에 사과가 있는 경우
            if (apple[nr][nc]) {
                apple[nr][nc] = false;  // 사과 제거
                // 꼬리는 움직이지 않음 (몸길이 증가)
            } else {
                // ⑤ 사과가 없는 경우 -> 꼬리 제거 (몸길이 유지)
                int[] tail = snake.removeLast();
                occupied[tail[0]][tail[1]] = false;
            }

            // ⑥ 이동이 끝난 뒤, 해당 시간에 방향 전환 정보가 있으면 회전
            if (turns.containsKey(time)) {
                char t = turns.get(time);

                if (t == 'L') {
                    // 왼쪽 회전 → 방향 -1 (mod 4)
                    dir = (dir + 3) % 4;
                } else if (t == 'D') {
                    // 오른쪽 회전 → 방향 +1 (mod 4)
                    dir = (dir + 1) % 4;
                }
            }
        }
    }
}
