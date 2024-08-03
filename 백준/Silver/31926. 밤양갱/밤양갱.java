import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 8;

        for (int i = 1; ; i++) {
            if (n - Math.pow(2, i) == 0) {
                result = result + i + 2; 
                break;
            } else if (n - Math.pow(2, i) < 0) {
                result = result + i + 1; 
                break;
            }
        }
        System.out.println(result);
    }
}
