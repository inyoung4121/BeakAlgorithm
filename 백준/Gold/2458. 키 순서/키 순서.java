import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] adj;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0;

        adj = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            adj[s][t] = true;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (adj[i][k]) {
                    for (int j = 1; j <= N; j++) {
                        if (adj[k][j]) {
                            adj[i][j] = true;
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            boolean isConn = true;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (adj[i][j] == false && adj[j][i] == false) {
                    isConn = false;
                    break;
                }
            }
            if (isConn) ans++;
        }
        System.out.println(ans);
    }


}