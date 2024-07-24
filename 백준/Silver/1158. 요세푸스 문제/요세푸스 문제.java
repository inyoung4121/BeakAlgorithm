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
        Queue<Integer> list = new LinkedList<>();

        for( int i = 1; i < n+1; i++ ) {
            list.offer(i);
        }

        sb.append("<");
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (j == m - 1) {
                    sb.append(list.poll()).append(", ");
                } else {
                    list.offer(list.poll());
                }
            }
        }
        String str = sb.substring(0, sb.length()-2);
        System.out.print(str);
        System.out.print('>');
    }
}

