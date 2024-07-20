import java.io.*;
import java.util.*;


//<>는 안바꿈
//>공백, 공백공백 , 공백< ,>< 4가지 경우는 한 단어로 보고 뒤집는다.
//한 단어씩 불러오고 뒤집어야 하는지 체크
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> sales = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            sales.put(book, sales.getOrDefault(book, 0) + 1);
        }

        String bestSeller = "";
        int max =0;
        for(Map.Entry<String, Integer> entry : sales.entrySet()) {
            String book = entry.getKey();
            int sale = entry.getValue();

            if (sale > max) {
                max = sale;
                bestSeller = book;
            } else if (sale == max) {
                if (book.compareTo(bestSeller) < 0) {
                    bestSeller = book;
                }
            }
        }

        System.out.println(bestSeller);
    }
}

