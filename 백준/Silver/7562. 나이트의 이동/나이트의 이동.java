import java.io.*;
import java.util.*;


//8방향으로 계속 진행 해 나가면서 만나면 종료
public class Main {
    static int boardSize;
    static int startX, startY, endX, endY;
    static int[][] movesCount;
    static boolean[][] visited;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            boardSize = Integer.parseInt(br.readLine());

            movesCount = new int[boardSize][boardSize];
            visited = new boolean[boardSize][boardSize];

            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            bfs();

            sb.append(movesCount[endX][endY]).append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            // 목적지에 도착했을 때 탐색 종료
            if (currentX == endX && currentY == endY) {
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                //8번 반복
                if (isInBounds(nextX, nextY)) {
                    queue.add(new int[]{nextX, nextY});
                    movesCount[nextX][nextY] = movesCount[currentX][currentY] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    public static boolean isInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < boardSize && y < boardSize && !visited[x][y];
    }
}
