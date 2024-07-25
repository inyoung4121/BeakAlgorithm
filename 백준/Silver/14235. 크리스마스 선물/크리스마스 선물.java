import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a==0) {
                if(queue.isEmpty())
                    sb.append("-1").append("\n");
                else
                    sb.append(queue.poll()).append("\n");
            }
            if(a!=0) {
                for(int i=0;i<a;i++)
                    queue.add(Integer.parseInt(st.nextToken()));
            }
        }
        System.out.println(sb);
    }

}
