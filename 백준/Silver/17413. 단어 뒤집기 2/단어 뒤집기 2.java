import java.io.*;
import java.util.*;


//<>는 안바꿈
//>공백, 공백공백 , 공백< ,>< 4가지 경우는 한 단어로 보고 뒤집는다.
//한 단어씩 불러오고 뒤집어야 하는지 체크
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        
        char recordStart = '<';
        char recordEnd = '>';
        char space = ' ';
        char check = space;

        for (char c : str.toCharArray()) {
            if (check == recordStart) {
                if (c == recordEnd) {
                    check = recordEnd;
                }
                sb.append(c);
            } else if (check == recordEnd) {
                if (c == recordStart) { //단어 뒤집어서 넣어줌
                    check = recordStart;
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                    continue;
                } else if (c == space) { //단어 뒤집어서 넣어줌
                    check = space;
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                    continue;
                }
                stack.add(c);
            } else {
                if (c == recordStart) { //단어 뒤집어서 넣어줌
                    check = recordStart;
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(check);
                    continue;
                } else if (c == space) { //단어 뒤집어서 넣어줌
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(check);
                    continue;
                }
                stack.add(c);
            }
        }

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
        }
        System.out.println(sb.toString());
    }
}

