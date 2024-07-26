import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 대체 이게 무슨 소린지
// 블로그 봐도 이해가 안됨
// 어쩃든 서류 합격 순위대로 합격 시키면서 최소 면접 점수를 갱신해나간다
// 최소면접점수보다 낮으면 탈락
class people implements Comparable<people> {
    int first;
    int second;

    public people(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(people o) {
        return this.first - o.first;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            List<people> peopleList = new ArrayList<>();
            int result = 0;
            int minValue = Integer.MAX_VALUE;
            int peopleCount = Integer.parseInt(br.readLine());
            while (peopleCount-- > 0) {
                st = new StringTokenizer(br.readLine());
                peopleList.add(new people(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(peopleList);

            for (people p : peopleList) {
                if (minValue > p.second) {
                    minValue = p.second;
                    result++;
                }
            }

            System.out.println(result);
        }

    }
}

