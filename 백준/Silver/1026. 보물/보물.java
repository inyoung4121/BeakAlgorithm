import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//그냥 두개 다 정렬하면 되지 않나?? 알게뭐람
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] arrA = new int[n];
        Integer[] arrB = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            arrB[j] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB,Collections.reverseOrder());


        int result = 0;
        for (int i = 0; i < n; i++) {
            result +=  arrA[i] * arrB[i];
        }
        System.out.println(result);
    }
}

