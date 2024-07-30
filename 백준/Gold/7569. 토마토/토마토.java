import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] box = new int[h][n][m];
        boolean[][][] visited = new boolean[h][n][m];
        Queue<int[]> queue = new LinkedList<>();
        int totalTomatoes = 0;
        int ripeTomatoes = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k, 0});
                        visited[i][j][k] = true;
                        ripeTomatoes++;
                    }
                    if (box[i][j][k] != -1) {
                        totalTomatoes++;
                    }
                }
            }
        }

        if (ripeTomatoes == totalTomatoes) {
            System.out.println(0);
            return;
        }

        int result = 0;

        int[] dx = new int[]{1, -1, 0, 0, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1, 0, 0};
        int[] dz = new int[]{0, 0, 0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            result = cur[3];

            for (int i = 0; i < 6; i++) {
                int nx = cur[2] + dx[i];
                int ny = cur[1] + dy[i];
                int nz = cur[0] + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < m && ny < n && nz < h) {
                    if (!visited[nz][ny][nx] && box[nz][ny][nx] == 0) {
                        visited[nz][ny][nx] = true;
                        box[nz][ny][nx] = 1;
                        queue.offer(new int[]{nz, ny, nx, cur[3] + 1});
                        ripeTomatoes++;
                    }
                }
            }
        }

        if (ripeTomatoes == totalTomatoes) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
