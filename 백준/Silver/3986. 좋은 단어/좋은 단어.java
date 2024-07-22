import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while (n-->0){
            String str = br.readLine();
            if(str.length() % 2==1) continue;
            Stack<Character> stack = new Stack<>();
            stack.push(str.charAt(0));
            for(int i=1;i<str.length();i++){
                if(!stack.isEmpty()){
                    if(stack.peek()==str.charAt(i)){stack.pop();continue;}
                }
                stack.push(str.charAt(i));
            }
            if(stack.isEmpty()){count++;}
        }
        System.out.println(count);
    }
}
