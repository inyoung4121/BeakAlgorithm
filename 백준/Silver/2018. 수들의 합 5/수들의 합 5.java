
import java.util.Scanner;

//투포인터
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.close(); // Close the scanner to free up resources

        int left = 1; 
        int right = 1; 
        int sum = 1; 
        int res = 0;

        while (right <= n) {
            if (sum < n) {
                sum += ++right;
            } else if (sum == n) {
                res++;
                sum -= left++;
            } else {
                sum -= left++;
            }
        }
        System.out.println(res);
    }
}
