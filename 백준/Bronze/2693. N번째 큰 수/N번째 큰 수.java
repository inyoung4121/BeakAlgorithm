import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            System.out.println(list.get(7));
        }
    }
}