import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numString;

        while ((numString = br.readLine()) != null) {
            sb = new StringBuilder();
            int n = Integer.parseInt(numString);
            sb.append("-");
            getResult(n);
            System.out.println(sb.toString());
        }
    }
    public static void getResult( int n){
        if(n == 0)return;

        String tmp = sb.toString();
        sb.append(" ".repeat(tmp.length()));
        sb.append(tmp);
        getResult(n-1);
    }
}
