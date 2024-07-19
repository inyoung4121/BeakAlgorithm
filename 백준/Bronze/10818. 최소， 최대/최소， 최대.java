import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (n-- > 0) {
            int tmp = sc.nextInt();
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
        }
        System.out.println(min + " " +max);
    }
}