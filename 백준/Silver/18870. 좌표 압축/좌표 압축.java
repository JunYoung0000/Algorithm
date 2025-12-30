import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(st.nextToken());
            list.add(a);
            arr[i] = a;
        }

        Collections.sort(list);

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int i = 0; i < N; i++){
            if(map.getOrDefault(list.get(i), -1) == -1){
                map.put(list.get(i), idx++);
            }
        }

        for(int i = 0; i < N; i++){
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}