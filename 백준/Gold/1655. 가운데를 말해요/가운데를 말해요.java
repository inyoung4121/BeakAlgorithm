import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if( left.size()==right.size()){
                left.offer(number);
            }else{
                right.offer(number);
            }

            if( ! left.isEmpty() && !right.isEmpty()  &&left.peek()>right.peek()){
                right.offer(left.poll());
                left.offer(right.poll());
            }
            sb.append(left.peek()+"\n");
        }
        System.out.println(sb);
    }
}
