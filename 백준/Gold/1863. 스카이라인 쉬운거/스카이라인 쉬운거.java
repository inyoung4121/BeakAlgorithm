import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > h) {
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == h) {
                continue;
            }

            stack.push(h);
            if (h > 0) {
                result++;
            }
        }

        System.out.println(result);
    }
}
