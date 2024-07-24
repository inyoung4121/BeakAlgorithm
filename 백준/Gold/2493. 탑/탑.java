import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        for (int i = 1; i < n + 1; i++) {
            int[] arr = new int[]{i, Integer.parseInt(st.nextToken())};
            while (!stack.isEmpty()) {
                if (stack.peek()[1] < arr[1]) {
                    stack.pop();
                } else {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
            }
            if(stack.isEmpty()){
                System.out.print("0 ");
            }
            stack.push(arr);
        }
    }

}

