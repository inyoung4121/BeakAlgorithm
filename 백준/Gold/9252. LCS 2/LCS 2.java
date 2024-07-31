import java.io.*;
import java.util.*;

public class Main {
    static String a, b, ans = "";

    public static void LCS(int l1, int r1, int l2, int r2) {
        // base case
        if (l1 > r1) return;
        if (l1 == r1) {
            for (int i = l2; i <= r2; i++) {
                if (b.charAt(i) == a.charAt(l1)) {
                    ans += b.charAt(i);
                    break;
                }
            }
            return;
        }

        // DP
        int mid = (l1 + r1) / 2;
        int[] LCS1 = new int[r2 - l2 + 3];
        int[] LCS2 = new int[r2 - l2 + 3];
        int[] Prv = new int[r2 - l2 + 3];

        for (int i = l1; i <= mid; i++) {
            for (int j = l2; j <= r2; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    LCS1[j - l2 + 1] = Prv[j - l2] + 1;
                } else {
                    LCS1[j - l2 + 1] = Math.max(LCS1[j - l2], Prv[j - l2 + 1]);
                }
            }
            System.arraycopy(LCS1, 0, Prv, 0, LCS1.length);
        }

        Arrays.fill(Prv, 0);
        for (int i = r1; i > mid; i--) {
            for (int j = r2; j >= l2; j--) {
                if (a.charAt(i) == b.charAt(j)) {
                    LCS2[j - l2 + 1] = Prv[j - l2 + 2] + 1;
                } else {
                    LCS2[j - l2 + 1] = Math.max(LCS2[j - l2 + 2], Prv[j - l2 + 1]);
                }
            }
            System.arraycopy(LCS2, 0, Prv, 0, LCS2.length);
        }

        // DnC
        int mx = -1, idx = 0;
        for (int i = l2; i <= r2 + 1; i++) {
            if (mx < LCS1[i - l2] + LCS2[i - l2 + 1]) {
                mx = LCS1[i - l2] + LCS2[i - l2 + 1];
                idx = i;
            }
        }
        LCS(l1, mid, l2, idx - 1);
        LCS(mid + 1, r1, idx, r2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine().trim();
        b = br.readLine().trim();
        LCS(0, a.length() - 1, 0, b.length() - 1);
        System.out.println(ans.length());
        System.out.println(ans);
    }
}
