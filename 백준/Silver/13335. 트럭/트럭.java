import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 트럭 수
        int w = sc.nextInt(); // 다리 길이
        int L = sc.nextInt(); // 최대 하중
        int[] trucks = new int[n];
        for (int i = 0; i < n; i++) trucks[i] = sc.nextInt();

        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int weightOnBridge = 0;
        int idx = 0; // 다음에 올라갈 트럭 인덱스

        // 다리를 비우기 전까지 반복
        for (int i = 0; i < w; i++) bridge.add(0);

        while (!bridge.isEmpty()) {
            time++;
            weightOnBridge -= bridge.poll(); // 맨 앞 트럭 빠짐

            if (idx < n) {
                if (weightOnBridge + trucks[idx] <= L) {
                    bridge.add(trucks[idx]);
                    weightOnBridge += trucks[idx];
                    idx++;
                } else {
                    bridge.add(0);
                }
            }
        }

        System.out.println(time);
    }
}
