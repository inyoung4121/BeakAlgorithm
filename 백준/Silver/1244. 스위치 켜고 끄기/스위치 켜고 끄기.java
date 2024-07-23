import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int students = Integer.parseInt(br.readLine());
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            change(n, arr, gender, num);
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static void change(int n, int[] arr, int gender, int num) {
        if (gender == 1) {
            for (int i = num; i <= n; i += num) {
                arr[i] = arr[i] == 1 ? 0 : 1;
            }
        } else if (gender == 2) {
            arr[num] = arr[num] == 1 ? 0 : 1;
            int left = num - 1;
            int right = num + 1;
            while (left >= 1 && right <= n && arr[left] == arr[right]) {
                arr[left] = arr[left] == 1 ? 0 : 1;
                arr[right] = arr[right] == 1 ? 0 : 1;
                left--;
                right++;
            }
        }
    }
}
