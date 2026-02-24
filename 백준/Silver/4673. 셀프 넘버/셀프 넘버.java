import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[10001];

    public static void main(String[] args) {
        for (int i = 1; i < visited.length; i++) {
            int dn = Kaprekar(i);
            if (dn < visited.length) {
                visited[dn] = true;
            }
        }

        for(int i = 1; i < visited.length; i++){
            if(!visited[i]){
                System.out.println(i);
            }
        }

    }

    static int Kaprekar(int x) {
        int input = x;

        while(input > 0){
            x += input % 10;
            input /= 10;
        }

        return x;
    }
}
