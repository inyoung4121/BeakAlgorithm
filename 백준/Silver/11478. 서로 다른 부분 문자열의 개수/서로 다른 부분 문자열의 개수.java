import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Set<String> set = new HashSet<>();

        for (int i = 1; i < str.length() + 1; i++) {
            for (int j = 0; j <= str.length() - i; j++) {
                set.add(str.substring(j, j + i));
            }
        }
        System.out.println(set.size());
    }
}

