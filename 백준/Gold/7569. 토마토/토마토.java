import java.io.*;
import java.util.*;

class Tomato {
    int x, y, z, day;

    public Tomato(int x, int y, int z, int day) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }
}

public class Main {
    static int M, N, H;
    static int[][][] box;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.offer(new Tomato(m, n, h, 0));
                        visited[h][n][m] = true;
                    }
                }
            }
        }

        int days = bfs();

        if (checkAllRipened()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    static int bfs() {
        int maxDays = 0;

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            maxDays = tomato.day;

            for (int i = 0; i < 6; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                int nz = tomato.z + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
                    if (!visited[nz][ny][nx] && box[nz][ny][nx] == 0) {
                        visited[nz][ny][nx] = true;
                        box[nz][ny][nx] = 1;
                        queue.offer(new Tomato(nx, ny, nz, tomato.day + 1));
                    }
                }
            }
        }

        return maxDays;
    }

    static boolean checkAllRipened() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
