import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrX = new int[n];
        int[] arrY = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrX[i] = Integer.parseInt(st.nextToken());
            arrY[i] = Integer.parseInt(st.nextToken());
        }

        double sum1 = 0;
        double sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum1 += (double)arrX[i] * arrY[(i + 1) % n] /2.0;
            sum2 += (double) arrY[i] * arrX[(i + 1) % n]/2.0;
        }

        System.out.printf("%.1f",Math.abs(sum1 - sum2) );
    }
}
