import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        while (n-- > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();
            switch (str) {
                case "push":
                    stack.push(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? "1" : "0");
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
            }
        }
    }
}
