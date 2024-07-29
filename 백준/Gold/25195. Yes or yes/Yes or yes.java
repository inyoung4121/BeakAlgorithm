import java.io.*;
import java.util.*;


public class Main {
    static boolean result = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        int s = Integer.parseInt(br.readLine());
        List arr = new ArrayList();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < s; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        dfs(arr, list, 1);

        System.out.println(result ? "Yes" : "yes");
    }

    static void dfs(List arr, ArrayList<Integer>[] list, int start) {
        if (arr.contains(start)) {
            return;
        }

        if (list[start].isEmpty()) {
            result = false;
        }

        for (int next : list[start]) {
            dfs(arr, list, next);
        }
    }
}

