import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Character> list = new ArrayList<>();
            list.add(st.nextToken().charAt(0));
            for (int i = 0; i < num-1; i++){
                char c = st.nextToken().charAt(0);
                if(list.get(0)>=c){

                    list.add(0,c);
                }else{
                    list.add(c);
                }
            }
            for(int i = 0; i < list.size(); i++){
                sb.append(list.get(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
