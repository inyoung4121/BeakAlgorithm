import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (n-- > 0) {
            String s = br.readLine();
            int result = checkPalindrome(s);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (isPalindrome(s, left + 1, right)) {
                    return 1;
                } else if (isPalindrome(s, left, right - 1)) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 0;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
