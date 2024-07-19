import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- >0){
            int tmp = sc.nextInt();
            int index = 0;
            while (tmp > 0){
                if(tmp%2==1){
                    System.out.print(index + " ");
                }
                index++;
                tmp /= 2;
            }
            System.out.println();

        }
    }
}