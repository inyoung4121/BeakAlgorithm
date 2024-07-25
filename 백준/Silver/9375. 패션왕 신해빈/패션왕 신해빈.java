import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int n = sc.nextInt();
            HashMap<String, Integer> clothes = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                sc.next();  // 의상의 이름은 무시합니다.
                String type = sc.next();
                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }
            
            // DP 배열 초기화
            int[] dp = new int[n + 1];
            dp[0] = 1;  // 아무 것도 안 입는 경우 1가지
            
            for (int count : clothes.values()) {
                for (int j = n; j >= 0; j--) {
                    dp[j] = dp[j] * (count + 1);
                }
            }
            
            // 최종 결과에서 아무것도 입지 않는 경우 하나를 뺀다
            System.out.println(dp[0] - 1);
        }
        
        sc.close();
    }
}
