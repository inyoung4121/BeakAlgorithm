import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int targetValue = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {  // Corrected loop condition to i < N
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, result = 0, left = 0, right = 0;
        while (right <= N) {  // Changed condition to right < N
            if (sum >= targetValue) {
                sum -= arr[left++];
            } else {
                sum += arr[right++];
            }
            if (sum == targetValue) {
                result++;
            }
        }
        System.out.println(result);
    }
}
