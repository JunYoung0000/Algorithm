import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            Long n = Long.parseLong(br.readLine());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Long> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> {
            int freqCompare = map.get(b) - map.get(a);
            if (freqCompare != 0) return freqCompare;

            return a.compareTo(b);
        });

        System.out.println(list.get(0));
    }
}