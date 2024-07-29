import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Integer>[] edges = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dist[x] = 0;

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (dist[cur] > k) break;
            if (dist[cur] == k) result.add(cur);

            for (int next : edges[cur]) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int cur : result) {
            sb.append(cur).append('\n');
        }

        System.out.print(result.isEmpty() ? -1 : sb);
    }
}

