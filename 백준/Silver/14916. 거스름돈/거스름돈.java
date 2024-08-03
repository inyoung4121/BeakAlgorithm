import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = n/5; i >= 0; i--) {
            for (int j = 0; j < 5; j++) {
                if(n == i*5 + j*2){
                    System.out.println(i+j);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
