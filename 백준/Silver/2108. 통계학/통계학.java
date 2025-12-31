import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            int value = map.getOrDefault(num, 0) + 1;
            map.put(num, value);
            if(max < value) max = value;
        }

        Arrays.sort(arr);

        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            if(map.get(num) == max){
                set.add(num);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        int a =  (int) Math.round((double) sum / N);
        int b = (arr.length != 1) ? arr[N/2] : arr[0];
        int c;
        int d = arr[N - 1] - arr[0];


        if(list.size() == 1){
            c = list.get(0);
        } else{
            Collections.sort(list);
            c = list.get(1);
        }

        sb.append(a).append("\n").append(b).append("\n").append(c).append("\n").append(d).append("\n");
        System.out.println(sb);
    }
}