import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        // 파일 이름에서 확장자를 추출하고 카운트
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            String extension = name.substring(name.lastIndexOf(".") + 1);
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        // TreeMap으로 변환하여 확장자 이름을 사전순으로 정렬
        Map<String, Integer> sortedMap = new TreeMap<>(map);

        // 결과 출력
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
