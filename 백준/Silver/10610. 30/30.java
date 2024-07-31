import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i] - '0';
            sb.append(arr[i]);
            if( i==0 && arr[i] != '0'){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(sum % 3 == 0 ? sb : -1);
    }
}
