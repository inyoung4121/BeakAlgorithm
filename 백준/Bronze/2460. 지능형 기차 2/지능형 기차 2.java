import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int max = Integer.MIN_VALUE;
        int in =0, out =0;
        for (int i=0; i<10; i++){
            out = sc.nextInt();
            in = sc.nextInt();
            count -=out;
            count +=in;
            max = Math.max(max,count);
        }
        System.out.println(max);
    }
}