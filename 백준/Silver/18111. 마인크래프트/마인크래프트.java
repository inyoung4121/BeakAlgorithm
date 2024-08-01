import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 높이별 개수
        int[] heightCounts = new int[257];
        // 최소 높이
        int min = Integer.MAX_VALUE;
        // 최대 높이
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int height = Integer.parseInt(st.nextToken());
                heightCounts[height]++;
                min = Math.min(min, height);
                max = Math.max(max, height);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int bestHeight = -1;

        for (int targetHeight = min; targetHeight <= max; targetHeight++) {
            int time = 0;
            int inventory = b;

            for (int height = 0; height <= 256; height++) {
                if (heightCounts[height] > 0) {
                    if (height > targetHeight) {
                        time += (height - targetHeight) * heightCounts[height] * 2;
                        inventory += (height - targetHeight) * heightCounts[height];
                    } else if (height < targetHeight) {
                        time += (targetHeight - height) * heightCounts[height];
                        inventory -= (targetHeight - height) * heightCounts[height];
                    }
                }
            }

            if (inventory >= 0 && time <= minTime) {
                minTime = time;
                bestHeight = targetHeight;
            }
        }

        System.out.println(minTime + " " + bestHeight);
    }
}
