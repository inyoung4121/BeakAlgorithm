import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 0, 1};
    static int answer = 0;

    // 범위 체크 and 벽 체크
    static boolean chk(int r, int c) {
        if (r < 1 || r > N || c < 1 || c > N || map[r][c] == 1) return false;
        else return true;
    }

    static void DFS(int r, int c, int dir) {
        if (r == N && c == N) {
            answer++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            // 가로->세로 or 세로->가로 안됨
            if ((dir == 0 && i == 1) || (dir == 1 && i == 0)) continue;

            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!chk(nr, nc)) continue;     // 범위 벗어나거나 벽이면 
            if (i == 2 && (map[r+1][c] == 1 || map[r][c+1] == 1)) continue;    // 대각선인데 나머지 칸이 벽이면 
            DFS(nr, nc, i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        map = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        DFS(1, 2, 0);
        System.out.println(answer);

        scanner.close();
    }
}