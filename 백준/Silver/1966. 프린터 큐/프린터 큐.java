import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int totalCase = Integer.parseInt(br.readLine());

        while (totalCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                q.offer(new int[]{i, priority});
                priorityQueue.offer(priority);
            }

            int count = 0;

            while (!q.isEmpty()) {
                int[] temp = q.poll();
                if (temp[1] == priorityQueue.peek()) {
                    count++;
                    priorityQueue.poll();
                    if (temp[0] == m) {
                        output.append(count).append("\n");
                        break;
                    }
                } else {
                    q.offer(temp);
                }
            }
        }
        System.out.print(output.toString());
    }
}
