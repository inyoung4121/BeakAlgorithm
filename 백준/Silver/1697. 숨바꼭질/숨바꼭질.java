import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int[] count = new int[100_002]; // 배열 크기를 100002로 변경
        Arrays.fill(count, -1); // 배열 초기화
        count[n] = 0; // 시작점 초기화

        if (n == m) {
            System.out.println(0);
            return;
        }

        loop:
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < 3; i++) {
                int nX;
                if (i == 0) {
                    nX = x + 1;
                } else if (i == 1) {
                    nX = x - 1;
                } else {
                    nX = x * 2;
                }
                if (nX == m) {
                    System.out.println(count[x] + 1);
                    break loop;
                }
                if (nX >= 0 && nX < 100002 && count[nX] == -1) { // 배열 경계와 값 검사
                    q.add(nX);
                    count[nX] = count[x] + 1;
                }
            }
        }
    }
}
