import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Set<String> apples = new HashSet<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int appleX = Integer.parseInt(st.nextToken());
            int appleY = Integer.parseInt(st.nextToken());
            apples.add(appleX + "," + appleY);
        }

        int movingCount = Integer.parseInt(br.readLine());
        Queue<int[]> movingPoints = new LinkedList<>();
        for (int i = 0; i < movingCount; i++) {
            st = new StringTokenizer(br.readLine());
            int movingTime = Integer.parseInt(st.nextToken());
            int direction = st.nextToken().equals("L") ? -1 : 1;
            movingPoints.add(new int[]{movingTime, direction});
        }

        System.out.println(start(apples, movingPoints));
    }

    static int start(Set<String> apples, Queue<int[]> movingPoints) {
        int result = 0;
        int x = 1, y = 1;
        int direction = 0; // 초기 방향: 동쪽
        Queue<int[]> snake = new LinkedList<>();
        snake.add(new int[]{x, y});
        Set<String> snakeSet = new HashSet<>();
        snakeSet.add(x + "," + y);

        while (true) {
            int nextX = x + dx[direction];
            int nextY = y + dy[direction];
            result++;

            // 벽에 부딛히거나 몸통에 부딛히면 종료
            if (!isInBounds(nextX, nextY) || snakeSet.contains(nextX + "," + nextY)) {
                break;
            }

            // 1초 진행, 1칸 전진
            snake.add(new int[]{nextX, nextY});
            snakeSet.add(nextX + "," + nextY);


            // 방향이 바뀌는지 확인하고 바꿔준다
            if (!movingPoints.isEmpty() && movingPoints.peek()[0] == result) {
                int[] move = movingPoints.poll();
                direction = (direction + move[1] + 4) % 4;
            }

            // 사과를 만나는지 확인한다
            if (apples.contains(nextX + "," + nextY)) {
                apples.remove(nextX + "," + nextY);
            } else {
                int[] tail = snake.poll();
                assert tail != null;
                snakeSet.remove(tail[0] + "," + tail[1]);
            }


            x = nextX;
            y = nextY;
        }

        return result;
    }

    static boolean isInBounds(int x, int y) {
        return x > 0 && x <= n && y > 0 && y <= n;
    }

}
