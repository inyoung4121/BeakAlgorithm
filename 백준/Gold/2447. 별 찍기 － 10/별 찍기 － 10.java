import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        star = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                star[i][j] = '*';
            }
        }
        getStar(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void getStar(int startR, int startC, int N) {
        int aThird = N / 3;
        if (N == 1) return;
        for (int i = startR + aThird; i < startR + 2 * aThird; i++) {
            for (int j = startC + aThird; j < startC + 2 * aThird; j++) {
                star[i][j] = ' ';
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                getStar(startR + i * aThird, startC + j * aThird, aThird);
            }
        }

    }
}
