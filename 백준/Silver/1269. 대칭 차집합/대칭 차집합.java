import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            setA.add(num);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            setB.add(num);
        }

        int countA = 0;
        int countB = 0;

        for(int n : setA){
            if(!setB.contains(n)) countA++;
        }

        for(int n : setB){
            if(!setA.contains(n)) countB++;
        }

        System.out.println(countA + countB);
    }
}
