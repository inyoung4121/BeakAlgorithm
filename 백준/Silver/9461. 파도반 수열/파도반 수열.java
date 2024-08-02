import java.io.*;
import java.util.*;


//dp[n] = dp[n-1]+dp[n-5]
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] dp = new long[100];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        for(int i = 5; i < 100; i++){
            dp[i] = dp[i-1] + dp[i - 5];
        }
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            int a = Integer.parseInt(br.readLine());
            sb.append(dp[a-1]).append("\n");
        }
        System.out.println(sb);
    }
}
