
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine()).nextToken());
        int quotient = n / 5;
        int remainder = n % 5;
        while (quotient >= 0) {
            if (remainder % 3 == 0) { 
                int countOfThree = remainder / 3;
                System.out.println(quotient + countOfThree);
                return;
            }
            quotient--;
            remainder += 5;
        }
        System.out.println(-1);
    }
}
