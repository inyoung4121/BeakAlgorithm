import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            list.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (!list.isEmpty()) {
            int move = list.get(idx)[1];
            sb.append(list.remove(idx)[0]).append(" ");

            if (list.isEmpty()) break;

            if (move > 0) {
                idx = (idx + (move - 1)) % list.size();
            } else {
                idx = (idx + move) % list.size();
                if (idx < 0) idx += list.size();
            }
        }
        System.out.println(sb);
    }
}
