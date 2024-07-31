import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        int max = 0;
        int maxIndexA = 0;
        int maxIndexB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a= 0;
                while (a<list.get(i).length() && a<list.get(j).length() && list.get(i).charAt(a) == list.get(j).charAt(a)) {
                    a++;
                }
                if (max < a) {
                    max = a;
                    maxIndexA = i;
                    maxIndexB = j;
                }
            }
        }
        System.out.println(list.get(maxIndexA));
        System.out.println(list.get(maxIndexB));
    }
}
