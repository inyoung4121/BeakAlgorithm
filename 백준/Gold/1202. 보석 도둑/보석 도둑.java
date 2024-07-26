import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 보석 클래스: 무게와 가치를 가짐
class Jewel implements Comparable<Jewel> {
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jewel o) {
        // 무게 기준으로 정렬
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> jewels = new ArrayList<>();
        List<Integer> backpacks = new ArrayList<>();

        // 보석 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(weight, value));
        }

        // 가방 입력
        for (int i = 0; i < K; i++) {
            backpacks.add(Integer.parseInt(br.readLine()));
        }

        // 보석을 무게 기준으로 정렬
        Collections.sort(jewels);
        // 가방을 크기 기준으로 정렬
        Collections.sort(backpacks);

        // 가치가 높은 보석을 우선순위 큐로 처리
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long totalValue = 0;
        int j = 0;

        // 가방을 처리하면서 적절한 보석을 선택
        for (int bagSize : backpacks) {
            // 현재 가방 크기와 맞는 모든 보석을 큐에 추가
            while (j < N && jewels.get(j).weight <= bagSize) {
                pq.add(jewels.get(j).value);
                j++;
            }
            // 가장 높은 가치를 가진 보석을 선택
            if (!pq.isEmpty()) {
                totalValue += pq.poll();
            }
        }

        System.out.println(totalValue);
    }
}
