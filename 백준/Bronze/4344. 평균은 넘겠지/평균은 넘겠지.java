import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < totalCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int totalNumberOfStudent = Integer.parseInt(st.nextToken());
            int[] arr = new int[totalNumberOfStudent];
            double sum = 0;
            for (int j = 0; j < totalNumberOfStudent; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            double average = sum / totalNumberOfStudent;
            int overAverageStudentCount = 0;
            for (int j = 0; j < totalNumberOfStudent; j++) {
                if (arr[j] > average) {
                    overAverageStudentCount++;
                }
            }
            System.out.printf("%.3f%%\n", (overAverageStudentCount / (double) totalNumberOfStudent) * 100);
        }
    }
}
