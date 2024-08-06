import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str2 = br.readLine();
        int size = str.length();
        int size2 = str2.length();

        str = str.replaceAll(str2, "");
        System.out.println((size - str.length()) / size2);
    }
}
