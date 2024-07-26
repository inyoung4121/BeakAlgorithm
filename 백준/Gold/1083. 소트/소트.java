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

            int maxNum = 0;
            int maxIdx = -1;

            for (int j = i + 1; j < N; j++) {
                if (S >= j - i && list.get(i) < list.get(j) && list.get(j) > maxNum) {
                    maxNum = list.get(j);
                    maxIdx = j;
                }
            }

            if (maxIdx != -1) {
                list.add(i, list.remove(maxIdx));
                S -= maxIdx - i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}