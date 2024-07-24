import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for ( char c : str.toCharArray() ) {
            left.push(c);
        }
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            switch (tmp) {
                case "L":
                    if(left.isEmpty()) continue;
                    right.push(left.pop());
                    break;
                case "D":
                    if(right.isEmpty()) continue;
                    left.push(right.pop());
                    break;
                case "B":
                    if(left.isEmpty()) continue;
                    left.pop();
                    break;
                case "P":
                    left.push(st.nextToken().charAt(0));
            }
        }
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
