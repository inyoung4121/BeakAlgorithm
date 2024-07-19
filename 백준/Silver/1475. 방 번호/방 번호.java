import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        br.close();

        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : N.toCharArray()) {
            if(c =='9') c = '6';
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        countMap.put('6', (countMap.getOrDefault('6', 0) + 1) / 2); 
        
        System.out.println(Collections.max(countMap.values()));
    }
}
