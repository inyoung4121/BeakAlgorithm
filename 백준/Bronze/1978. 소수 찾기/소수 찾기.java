import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result =0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int asd = Integer.parseInt(st.nextToken());
            if(asd==1){continue;}
            if(asd==2){result++; continue;}
            for(int i=2; i<asd; i++) {
                if(asd%i==0) {
                    break;
                }else{
                    if(asd-1==i ){result++;}
                }
            }
        }
        System.out.println(result);
    }
}