import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (n-- > 0) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        for (int count = 0; count < t; count++) {
            if (pq.isEmpty()) {
                break;
            }

            int tallest = pq.poll();
            if (tallest < h) {
                System.out.println("YES");
                System.out.println(count);
                return;
            }

            if (tallest == 1) {
                pq.offer(tallest);
                continue;
            }

            pq.offer(tallest / 2);
        }

        if (!pq.isEmpty() && pq.peek() >= h) {
            System.out.println("NO");
            System.out.println(pq.peek());
        } else {
            System.out.println("YES");
            System.out.println(t);
        }
    }
}
