import java.io.*;
import java.util.*;

/*
 * 처리 : 이진탐색으로 값을 찾아나간다*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            q.offer(Integer.parseInt(st.nextToken()));
            q.offer(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) binarySearch(arr, q.poll(), q.poll(), sb);
        System.out.println(sb);
    }


    private static void binarySearch(int[] arr, int start, int end, StringBuilder sb) {



        int left=0;
        int right=arr.length-1;

        while(left<=right) {
            int mid=(left+right)/2;
            if(arr[mid]<start)
                left=mid+1;
            else
                right=mid-1;
        }
        int startIdx = left;

        left =0;
        right = arr.length-1;

        while(left<=right) {
            int mid=(left+right)/2;
            if(arr[mid]>end)
                right=mid-1;
            else
                left=mid+1;
        }

        int endIdx = left;


        sb.append(endIdx-startIdx).append("\n");
    }
}

