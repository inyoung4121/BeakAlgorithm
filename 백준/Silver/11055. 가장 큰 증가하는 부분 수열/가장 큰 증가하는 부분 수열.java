import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sumArr = new int[n];
        sumArr[0] = arr[0];

        for(int i = 1; i < n; i++) {
            sumArr[i] = arr[i];  // 현재 위치의 값으로 초기화
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    sumArr[i] = Math.max(sumArr[i], sumArr[j] + arr[i]);
                }
            }
        }

        int maxSum = sumArr[0];
        for(int i = 1; i < n; i++) {
            if(sumArr[i] > maxSum) {
                maxSum = sumArr[i];
            }
        }

        System.out.println(maxSum);
    }
}
