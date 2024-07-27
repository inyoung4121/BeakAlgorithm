import java.io.*;
import java.util.*;

/*
* 한 수의 부모는 n/2이다.
* 두 수가 주어지면 큰 수를 반씩 나눠가며 찾는다
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for( int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            while (x != y) {
                if (x > y) {
                    x = x / 2;
                } else {
                    y = y / 2;
                }
            }
            sb.append(x*10).append("\n");
        }
        System.out.println(sb);
    }
}
