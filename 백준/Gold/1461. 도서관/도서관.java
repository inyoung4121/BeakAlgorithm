import java.io.*;
import java.util.*;

/*
 * 입력 : -방향과 +방향을 각각 우선순위 큐에 넣어준다.
 * 가장 많은 걸음을 소비하는 m개의 책을 먼저 처리한다.
 * 나머지는 m개씩 빼가면서 처리한다.
 * 나머지는 순서대로 ㄱㄱ
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> leftQ = new PriorityQueue<>();
        PriorityQueue<Integer> rightQ = new PriorityQueue<>(Comparator.reverseOrder());

        while (N-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            if (x < 0) leftQ.offer(x);
            else rightQ.offer(x);
        }

        int leftMax = 0;
        int rightMax = 0;

        if (!leftQ.isEmpty()) leftMax = Math.abs(leftQ.peek());
        if (!rightQ.isEmpty()) rightMax = rightQ.peek();

        for (int i = 0; i < M; i++) {
            if (leftMax < rightMax) {
                if (!rightQ.isEmpty() && i == 0) {
                    result += rightQ.peek();
                }
                rightQ.poll();
            } else {
                if (!leftQ.isEmpty() && i == 0) {
                    result += Math.abs(leftQ.peek());
                }
                leftQ.poll();
            }
        }

        while (!leftQ.isEmpty()) {
            for (int i = 0; i < M; i++) {
                if (i == 0) {
                    result += Math.abs(leftQ.poll()) * 2;
                } else {
                    leftQ.poll();
                }
            }
        }
        while (!rightQ.isEmpty()) {
            for (int i = 0; i < M; i++) {
                if (i == 0) {
                    result += rightQ.poll() * 2;
                } else {
                    rightQ.poll();
                }
            }
        }
        System.out.println(result);
    }
}
