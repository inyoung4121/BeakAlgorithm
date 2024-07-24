import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        for( int i = 1; i < n+1; i++ ) {
            list.add(i);
        }

        int idx = 0;
        sb.append("<");
        for(int i=0; i<n; i++) {
            idx = (idx + m - 1) % list.size();
            sb.append(list.remove(idx)).append(", ");
        }
        String str = sb.substring(0, sb.length()-2);
        System.out.print(str);
        System.out.print('>');
    }
}