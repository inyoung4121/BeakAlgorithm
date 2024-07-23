import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left =0;
        int right = 0;
        int sum = arr[0];
        int result = Integer.MAX_VALUE;

        while (left < n) {
            if (sum < m) {
                if(right < n-1){
                    right++;
                    sum += arr[right];
                }else{
                    break;
                }
            }else{
                result = Math.min(result,right-left+1);
                sum -= arr[left];
                left++;
            }
        }
        System.out.println(result==Integer.MAX_VALUE?0:result);
    }

}
