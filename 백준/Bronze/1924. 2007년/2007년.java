import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken());
        int[] month = {0,31,59,90,120,151,181,212,243,273,304,334};
        String[] day = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        System.out.println(day[(month[x]+y-1)%7]);
    }
}
