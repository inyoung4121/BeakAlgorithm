import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int current = A;

        int[] visited = new int[300000];
        int count = 1;
        visited[current] = count;

        while (true) {
            int next = getNext(current, P);
            if (visited[next] != 0) { 
                System.out.println(visited[next] - 1);
                break;
            }
            visited[next] = ++count;
            current = next;
        }
    }

    public static int getNext(int num, int P) {
        int next = 0;
        while (num > 0) {
            int digit = num % 10;
            next += (int) Math.pow(digit, P);
            num /= 10;
        }
        return next;
    }
}
