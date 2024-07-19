import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if(num % i == 0) {
                list.add(i);
            }
        }
        if(list.size() >= k) {
            System.out.println(list.get(k-1));
        } else {
            System.out.println(0);
        }
    }
}
