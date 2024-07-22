import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int[] arr;
    public static int[] selected;
    public static boolean[] visited;
    public static Set<String> set = new HashSet<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        selected = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);

    }

    public static void dfs(int depth) {
        if (depth == m) {
            String str = "";
            for (int tmp : selected) {
                str += tmp + " ";
            }
            if (set.add(str)) {
                System.out.println(str);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            selected[depth] = arr[i];
            dfs(depth + 1);
            visited[i] = false;
        }

    }
}

