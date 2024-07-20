import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int max = Math.max(n, m);
        int min = Math.min(n, m);

        for (int i = max; i > 0; i--) {
            if(n%i == 0 && m%i == 0){
                max = i;
                break;
            }
        }
        while (min % n != 0 || min % m != 0) {
            min++;
        }
        System.out.println(max);
        System.out.println(min);
    }
}