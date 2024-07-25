import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


//경우의 수
//모자 2개 안경 1개
//[모자1,안경] [모자2,안경] 모자1 모자2 안경
//(2+1(입지않는경우)) x (1+1(입지않는경우)) -1 (아무것도 입지 않는경우)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {

            int clothesCount = Integer.parseInt(br.readLine());
            HashMap<String, Integer> clothes = new HashMap<>();
            while (clothesCount-- > 0) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String parts = st.nextToken();
                clothes.put(parts, clothes.getOrDefault(parts, 1) + 1);
            }
            int result =1;
            for (int clothe : clothes.values()) {
                result *= clothe;
            }
            System.out.println(--result);
        }
    }
}
