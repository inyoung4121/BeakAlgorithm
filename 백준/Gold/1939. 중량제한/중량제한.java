import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int from, to, wei;

    public Node(int from, int to, int wei) {
        this.from = from;
        this.to = to;
        this.wei = wei;
    }


    @Override
    public int compareTo(Node o) {
        return -this.wei + o.wei;
    }
}

public class Main {

    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) parent[i] = i;

        ArrayList<Node> A = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int wei = Integer.parseInt(st.nextToken());

            A.add(new Node(from, to, wei));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Collections.sort(A);

        for (Node n : A) {
            union(n.from, n.to);
            if(find(start) == find(end)){
                System.out.println(n.wei);
                return;
            }
        }
    }
    static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u == v) return;
        if(u > v) parent[u] = v;
        else parent[v] = u;

    }

    static int find(int v) {
        if(v == parent[v]) return v;

        parent[v] = find(parent[v]);
        return parent[v];
    }
}
