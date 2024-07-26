import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int S = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            int maxi = 0;
            int maxi_idx = -1;
            for (int j = i + 1; j < N; j++) {
                if (list.get(i) < list.get(j) && S >= j - i && list.get(j) > maxi) {
                    maxi = list.get(j);
                    maxi_idx = j;
                }
            }
            if (maxi_idx != -1) {
                list.remove(maxi_idx);
                list.add(i, maxi);
                S -= maxi_idx - i;
            }
        }
        System.out.println(list.toString().replaceAll("\\[", "").replaceAll("\\]", "").replace(",", ""));
    }
}