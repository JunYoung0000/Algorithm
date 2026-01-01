import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 1. 오름차순 정렬
        Arrays.sort(arr);

        int maxWeight = 0;

        // 2. 각 로프를 '가장 약한 로프'로 가정했을 때의 최대 중량 계산
        for(int i = 0; i < N; i++){
            // arr[i]는 현재 선택된 로프들 중 가장 작은 값
            // (N - i)는 arr[i]보다 크거나 같은 로프들의 개수
            int currentWeight = arr[i] * (N - i);

            // 3. 전체 중 최댓값 갱신
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
            }
        }

        System.out.println(maxWeight);
    }
}