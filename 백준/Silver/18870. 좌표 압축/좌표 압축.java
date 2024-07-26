import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//최대 n^2 = 10^12
//정렬 된 복사본을 만들고 몇번쨰인지 확인만?
//맵을 만들고 작은놈들만?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] copy = Arrays.stream(arr)
                .distinct()
                .sorted()
                .toArray();

        for (int i = 0; i < copy.length; i++) {
            if (map.containsKey(copy[i])) {
                continue;
            }
            map.put(copy[i], i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}

