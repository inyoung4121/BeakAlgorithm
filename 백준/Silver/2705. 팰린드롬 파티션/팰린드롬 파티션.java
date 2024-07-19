import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[] dp = new int[1005];
        for (int i = 1; i <= 1000; i++) dp[i] = 1;
        
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < i; j++) {
                if (((i - j) & 1) != 0) continue;
                dp[i] += dp[(i - j) >> 1];
            }
        }
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
