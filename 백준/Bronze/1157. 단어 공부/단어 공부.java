import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String asd = br.readLine().toUpperCase();

        char[] map = new char[26];
        for (char x : asd.toCharArray()) {
            map[x - 'A']++;
        }

        int freq = 0;
        char maxChar = '?';
        boolean found = false;

        for (int i = 0; i < 26; i++) {
            if (map[i] > freq) {
                freq = map[i];
                maxChar = (char) (i + 'A');
                found = false;
            } else if (map[i] == freq) {
                found = true;
            }
        }

        System.out.println(found ? "?" : maxChar);
    }
}