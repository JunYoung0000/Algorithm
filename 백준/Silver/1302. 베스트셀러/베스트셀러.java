import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }
        
        String answer = "";
        int maxCount = 0;
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String title = entry.getKey();
            int count = entry.getValue();
            
            if (count > maxCount) {
                maxCount = count;
                answer = title;
            } else if (count == maxCount) {
                // 사전순 비교
                if (title.compareTo(answer) < 0) {
                    answer = title;
                }
            }
        }
        
        System.out.println(answer);
    }
}
