import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> dancing = new HashSet<>();
        dancing.add("ChongChong"); // 처음에 춤추는 사람

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            // 둘 중 하나라도 춤을 추고 있다면
            if (dancing.contains(A) || dancing.contains(B)) {
                dancing.add(A);
                dancing.add(B);
            }
        }

        System.out.println(dancing.size());
    }
}