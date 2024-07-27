import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<int[]> queue = new LinkedList<>();
        int length = (int)Math.pow(2,n) - 1;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        queue.add(arr);

        int size = arr.length;
        int preSize = size;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            size = temp.length;

            if(preSize / 2 == size) {
                preSize = size;
                sb.append("\n");
            }

            sb.append(temp[size / 2]).append(" ");

            int mid = size / 2;
            if(mid > 0) {
                int[] arrLeft = Arrays.copyOfRange(temp, 0, mid);
                int[] arrRight = Arrays.copyOfRange(temp, mid + 1, size);
                queue.add(arrLeft);
                queue.add(arrRight);
            }
        }
        System.out.println(sb);
    }
}
