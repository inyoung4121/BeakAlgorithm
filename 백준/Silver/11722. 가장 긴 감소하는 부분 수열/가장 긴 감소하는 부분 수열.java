import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(br.readLine());
        stringTokenizer = new StringTokenizer(br.readLine());

        int[] arr = new int[num];
        int[] dp = new int[num];

        dp[0] = 1;

        for(int i=0; i<num; i++)
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());

        for(int i=1; i<num; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(arr[i] < arr[j])
                    max = Math.max(dp[j], max);
            }
            dp[i] = max + 1;
        }

        Arrays.sort(dp);

        System.out.println(dp[num-1]);
    }
}
