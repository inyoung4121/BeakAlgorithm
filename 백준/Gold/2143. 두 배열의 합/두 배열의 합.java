import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[a];
        for (int i = 0; i < a; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int b = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[b];
        for (int i = 0; i < b; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            int sum = 0;
            for (int j = i; j < a; j++) {
                sum += arr1[j];
                list1.add(sum);
            }
        }
        for (int i = 0; i < b; i++) {
            int sum = 0;
            for (int j = i; j < b; j++) {
                sum += arr2[j];
                list2.add(sum);
            }
        }

        Collections.sort(list1); // 리스트 1 정렬
        Collections.sort(list2); // 리스트 2 정렬

        long result = 0L;
        int left = 0;
        int right = list2.size() - 1;

        while (left < list1.size() && right >= 0) {
            int sum = list1.get(left) + list2.get(right);
            if (sum == n) {
                long ac =0, bc =0;
                int asv =list1.get(left);
                int bsv = list2.get(right);
                while(left< list1.size() && asv == list1.get(left)) {
                    left++;
                    ac++;
                }

                while(right>-1 && list2.get(right) == bsv) {
                    right--;
                    bc++;
                }
                result += ac*bc;
            } else if (sum < n) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(result);
    }
}
