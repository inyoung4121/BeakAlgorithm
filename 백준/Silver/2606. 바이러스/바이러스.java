import java.io.*;
import java.util.*;

/*
 * 입력 : 컴퓨터의 수 , 감염된 컴퓨터 , 라인
 * 처리 : 감염된 컴퓨터와 연결 된 컴퓨터들을 set에 넣는다.*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList();
        }

        for(int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(1);
        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited[cur]) continue;

            visited[cur] = true;
            set.add(cur);

            for (int next : list[cur]) {
                if (!visited[next]) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(set.size() - 1);
    }
}

