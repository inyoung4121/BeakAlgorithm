import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int count = 0;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int length = (int)Math.pow(2,N);

        visit(length,0,0,r,c);

        System.out.println(result);
    }

    public static void visit( int length, int startR, int startC, int r, int c) {
        if (length == 1) {
            return;
        }

        int halfLength = length / 2;

        if (r < startR + halfLength && c < startC + halfLength) {  // 1사분면
            visit(halfLength, startR, startC, r, c);
        } 
        if (r < startR + halfLength && c >= startC + halfLength) {  // 2사분면
            result += halfLength * halfLength;
            visit(halfLength, startR, startC + halfLength, r, c);
        }
        if (r >= startR + halfLength && c < startC + halfLength) {  // 3사분면
            result += 2 * halfLength * halfLength;
            visit(halfLength, startR + halfLength, startC, r, c);
        } 
        if (r >= startR + halfLength && c >= startC + halfLength){  // 4사분면
            result += 3 * halfLength * halfLength;
            visit(halfLength, startR + halfLength, startC + halfLength, r, c);
        }
    }
}
