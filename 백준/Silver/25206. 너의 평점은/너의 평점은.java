import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        float gradeSum = 0;
        float sum = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            float grade = Float.parseFloat(st.nextToken());
            gradeSum += grade;
            switch (st.nextToken()) {
                case "A+":
                    sum += (float) (grade * 4.5);
                    break;
                case "A0":
                    sum += (float) (grade * 4.0);
                    break;
                case "B+":
                    sum += (float) (grade * 3.5);
                    break;
                case "B0":
                    sum += (float) (grade * 3.0);
                    break;
                case "C+":
                    sum += (float) (grade * 2.5);
                    break;
                case "C0":
                    sum += (float) (grade * 2.0);
                    break;
                case "D+":
                    sum += (float) (grade * 1.5);
                    break;
                case "D0":
                    sum += (float) (grade * 1.0);
                    break;
                case "F":
                    break;
                case "P":
                    gradeSum -= grade;
                    break;
            }
        }

        System.out.printf("%.6f\n", sum/gradeSum);
    }
}

//14316	128