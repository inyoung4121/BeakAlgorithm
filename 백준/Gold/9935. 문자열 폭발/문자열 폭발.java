import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//방법 1. 스택에 하나 하나 담고 넣을때마다 bomb인지 꺼내서 확인하고 다시 넣는다.
//방법 2. 임시저장공간을 만들고 bomb.charAt(0)을 만나면 임시저장공간에 넣기 시작한다. bomb이 맞으면 폭파하고 아니면 넣어준다.
//    2.1 연쇄 폭파를 감지해야한다. 여러번 반복시켜야 하거나 메소드가 길어진다
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        Stack<Character> tmpStack ;
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            tmpStack = new Stack<>();
            stack.push(str.charAt(i));
            
            if(stack.size()>=bomb.length()){
                boolean isBomb = true;
                for(int j =0; j < bomb.length();j++){
                    char c = stack.pop();
                    tmpStack.push(c);
                    if(c!=bomb.charAt(bomb.length()-j-1)){
                        isBomb = false;
                        break;
                    }
                }
                if(!isBomb){
                    while(!tmpStack.isEmpty()){
                        stack.push(tmpStack.pop());
                    }
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            for(char c : stack){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
