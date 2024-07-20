import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> users = new HashSet<>();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if(input.equals("ENTER")){
                count +=users.size();
                users.clear();
            }else{
                users.add(input);
            }
        }
        System.out.println(count+users.size());
    }
}

