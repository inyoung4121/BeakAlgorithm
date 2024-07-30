import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] prv, to, las, sub;
    static int sz, cnt;
    static int[][] ans;
    static int[] ptr;

    static void addEdge(int u, int v) {
        sz++;
        to[sz] = v;
        prv[sz] = las[u];
        las[u] = sz;
    }

    static void dfs(int x, int p) {
        sub[x] = 1;
        for (int i = las[x]; i != 0; i = prv[i]) {
            if (to[i] != p) {
                dfs(to[i], x);
                sub[x] += sub[to[i]];
            }
        }
        if (sub[x] % 3 == 0) cnt++;
    }

    static void trace(int x, int p, int grp) {
        if (sub[x] % 3 == 0) grp = ++cnt;
        ans[grp][ptr[grp]++] = x;
        for (int i = las[x]; i != 0; i = prv[i]) {
            if (to[i] != p) {
                trace(to[i], x, grp);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        int maxNodes = n + 1;
        int maxEdges = 2 * n;
        prv = new int[maxEdges];
        to = new int[maxEdges];
        las = new int[maxNodes];
        sub = new int[maxNodes];
        ans = new int[n / 3 + 1][3];
        ptr = new int[n / 3 + 1];

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            addEdge(u, v);
            addEdge(v, u);
        }

        dfs(1, -1);

        if (cnt != n / 3) {
            sb.append("U\n");
        } else {
            cnt = 0;
            trace(1, -1, 0);

            sb.append("S\n");
            for (int i = 1; i <= n / 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(ans[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}
