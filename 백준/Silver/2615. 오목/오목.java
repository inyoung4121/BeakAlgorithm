import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board = new int[19][19];
    // 오른쪽, 아래쪽, 오른쪽 위, 오른쪽 아래 단위
    static int[] dh = {0, 1, -1, 1};
    static int[] dw = {1, 0, 1, 1};

    private static int result = 0;
    private static int[] resultDetail = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int h = 0; h < 19; h++) {
            for (int w = 0; w < 19; w++) {
                check(h, w);
            }
        }

        if (result == 0) {
            System.out.println(0);
        } else {
            System.out.println(result);
            System.out.println(resultDetail[0] + " " + resultDetail[1]);
        }
    }

    private static void check(int h, int w) {
        if (board[h][w] == 0) { 
            return; 
        }
        for (int d = 0; d < 4; d++) {
            int cnt = 1;
            int nextH = h + dh[d];
            int nextW = w + dw[d];
            while (verification(nextH, nextW) && board[nextH][nextW] == board[h][w]) {
                cnt++;
                if (cnt == 5) {
                    // 6목이 아닌지 확인
                    if (!verification(nextH + dh[d], nextW + dw[d]) || board[nextH + dh[d]][nextW + dw[d]] != board[h][w]) {
                        if (!verification(h - dh[d], w - dw[d]) || board[h - dh[d]][w - dw[d]] != board[h][w]) {
                            result = board[h][w];
                            resultDetail[0] = h + 1;
                            resultDetail[1] = w + 1;
                            return; // 5목을 찾으면 더 이상 탐색하지 않음
                        }
                    }
                }
                nextH += dh[d];
                nextW += dw[d];
            }
        }
    }

    private static boolean verification(int h, int w) {
        return h >= 0 && h < 19 && w >= 0 && w < 19;
    }
}
