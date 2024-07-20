import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> words = new HashSet<>();

        while (n-- >0){
            String plusWord = br.readLine();
            words.add(plusWord);
        }
        while (m-- >0){
            st = new StringTokenizer(br.readLine(),",");
            while (st.hasMoreTokens()){
                String word = st.nextToken();
                words.remove(word);
            }
            System.out.println(words.size());
        }
    }
}

