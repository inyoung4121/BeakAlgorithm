import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static char[][] arr ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], ' ');
        }

        drawStar(0, n - 1, n);

        StringBuilder sb = new StringBuilder();
        for (char[] row : arr) {
            sb.append(row);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void drawStar(int row, int col, int n) {
        if (n == 3) {
            arr[row][col] = '*';
            arr[row + 1][col - 1] = '*';arr[row + 1][col + 1] = '*';
            arr[row + 2][col - 2] = '*';arr[row + 2][col - 1] = '*';arr[row + 2][col] = '*';arr[row + 2][col + 1] = '*';arr[row + 2][col + 2] = '*';
            return;
        }

        int half = n / 2;
        drawStar(row, col, half);
        drawStar(row + half, col - half, half);
        drawStar(row + half, col + half, half);
    }
}
