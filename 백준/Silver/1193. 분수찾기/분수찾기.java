import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        scanner.close();


        int n = 1;
        int sum = 1;

        while (sum < X) {
            n++;
            sum = n * (n + 1) / 2;
        }

        n--;
        sum = n * (n + 1) / 2;
        int minusSum = X - sum;

        if ((n + 1) % 2 == 1) {
            System.out.println(n + 2 -minusSum + "/" + minusSum);
        }else{
            System.out.println(minusSum + "/" + (n + 2 -minusSum));
        }

    }
}
