import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String S;
    static int aCnt, bCnt, cCnt; 
    static boolean[][][][][] visited;

    static void input() {
        Reader scanner = new Reader();

        S = scanner.nextLine();
    }

    static void solution() {
        countAlphabet();

        visited = new boolean[aCnt + 1][bCnt + 1][cCnt + 1][3][3];
        dfs(aCnt, bCnt, cCnt, "", 0, 0);

        System.out.println(-1);
    }

    static void dfs(int a, int b, int c, String attendanceRecord, int prevPrev, int prev) {
        if(a == 0 && b == 0 && c == 0) {
            System.out.println(attendanceRecord);
            System.exit(0);
        }

        if(visited[a][b][c][prevPrev][prev]) return;

        visited[a][b][c][prevPrev][prev] = true;

        if(a > 0)
            dfs(a - 1, b, c, attendanceRecord + 'A', prev, 0);
        if(b > 0 && prev != 1)
            dfs(a, b - 1, c, attendanceRecord + 'B', prev, 1);
        if(c > 0 && prevPrev != 2 && prev != 2)
            dfs(a, b, c - 1, attendanceRecord + 'C', prev, 2);
    }

    static void countAlphabet() {
        for(int idx = 0; idx < S.length(); idx++) {
            char curAlphabet = S.charAt(idx);

            if(curAlphabet == 'A')
                aCnt++;
            else if(curAlphabet == 'B')
                bCnt++;
            else if(curAlphabet == 'C')
                cCnt++;
        }
    }

    public static void main(String[] args) {
        input();
        solution();
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        public Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }
}