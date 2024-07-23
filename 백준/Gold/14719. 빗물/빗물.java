import java.io.*;
import java.util.StringTokenizer;

//어떤문제일까??
//일단 높이를 하나씩 내려가면서 맞춰지는 구간이 있는지 확인해 나간다.
//-----해당 W에서 좌로 가장 큰값, 우로 가장 큰 값중 작은값 - 해당 크기 만큼 물이 찬다.
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < w - 1; i++) {
            int leftMax = 0;
            int rightMax =0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, arr[j]);
            }
            for (int j = i; j < w; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }
            if(leftMax > arr[i] && rightMax > arr[i]) {
                int select = Math.min(leftMax, rightMax);
                result += select - arr[i];
            }
        }
        System.out.println(result);
    }
}
