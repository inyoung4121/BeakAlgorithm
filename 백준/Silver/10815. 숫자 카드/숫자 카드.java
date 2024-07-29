import java.io.*;
import java.util.*;

/*
 * 처리 : 이진탐색으로 값을 찾아나간다*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            queue.add(Integer.parseInt(st.nextToken()));

        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int x = queue.poll();
            int left =0;
            int right = n-1;

            while(left <= right) {
                int mid = (left + right) / 2;
                if(arr[mid] < x) {
                    left = mid + 1;
                }else if(arr[mid] > x) {
                    right = mid - 1;
                }else{
                    break;
                }
            }
            if(left>right) {
                sb.append(0);
            }else{
                sb.append(1);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }
}

