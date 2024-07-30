import java.io.*;
import java.util.*;

class Node {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            q.offer(new Node(start, 0));
            visited[start] = true;

            int result = 0;
            while (!q.isEmpty()) {
                Node node = q.poll();

                if (node.vertex == end) {
                    result = node.weight;
                    break;
                }

                for (Node a : list[node.vertex]) {
                    if (!visited[a.vertex]) {
                        visited[a.vertex] = true;
                        q.offer(new Node(a.vertex, node.weight + a.weight));
                    }
                }
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
    }
}
