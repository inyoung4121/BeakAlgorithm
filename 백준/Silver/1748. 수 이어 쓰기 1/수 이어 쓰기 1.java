import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int length= (int)( Math.log10(num)+1 );
        long sum = 0;

        for (int i = 1; i < length; i++) {
            sum += (long) (i * 9 * Math.pow(10, i - 1));
        }
        long exNum = (long)((num - Math.pow(10, length-1)+1)*(length));
        System.out.println(sum + exNum);
    }
}
