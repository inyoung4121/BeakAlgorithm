import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        String name;


        StringTokenizer st ;
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            name = st.nextToken();
            st.nextToken();
            if (!set.add(name)) {
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        list.sort(Comparator.reverseOrder());

        for (String s : list) {
            System.out.println(s);
        }
    }
}
