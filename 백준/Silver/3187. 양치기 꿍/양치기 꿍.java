import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Character[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int x;
    static int y;
    static int k = 0, v = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        arr = new Character[x][y];
        visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            String s = br.readLine();
            for (int j = 0; j < y; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int resultK = 0;
        int resultV = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                k = 0; v = 0;
                if (!visited[i][j] && arr[i][j] != '#') {
                    dfs(i, j);
                    if (k > v) {
                        resultK += k;
                    } else {
                        resultV += v;
                    }
                }
            }
        }


        System.out.println(resultK + " " + resultV);
    }

    private static void dfs(int x, int y) {
        if (arr[x][y] == 'k') {
            k++;
        }
        if (arr[x][y] == 'v') {
            v++;
        }
        
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < Main.x && ny < Main.y) {
                if (!visited[nx][ny] && arr[nx][ny] != '#') {
                    dfs(nx, ny);
                }
            }
        }
    }
}