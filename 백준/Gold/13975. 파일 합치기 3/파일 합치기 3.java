import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            long result =0L ;
            int m = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (m-- >0) {pq.offer(Long.parseLong(st.nextToken()));}

            while (pq.size()>1) {
                Long a = pq.poll();
                Long b = pq.poll();
                Long sum = a + b;
                pq.offer(sum);
                result += sum;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
