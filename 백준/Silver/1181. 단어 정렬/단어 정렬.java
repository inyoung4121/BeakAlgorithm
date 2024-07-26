import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        String[] copy = Arrays.stream(arr)
                .distinct()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .toArray(String[]::new);

        StringBuilder sb = new StringBuilder();
        for (String s : copy) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}

