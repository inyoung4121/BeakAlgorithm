import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

/*비용이 낮은 순으로 정렬하고 낮은 순대로 뽑는다.
두 노드가 이미 뽑혀있으면 스킵
* */
class line implements Comparable<line> {
    int start;
    int end;
    int cost;
    public line(int start, int end,int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(line o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<line> lines = new ArrayList<line>();
        parents = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parents[i] = i;
        }
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines.add(new line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(lines);
        int result =0;

        for (int i = 0; i < M; i++) {
            if (findParent(lines.get(i).start) != findParent(lines.get(i).end)) {
                result+=lines.get(i).cost;
                union(lines.get(i).start, lines.get(i).end);
            }
        }
        System.out.println(result);
    }

    static void union(int start, int end) {
        int root1 = findParent(start);
        int root2 = findParent(end);

        if (root1 != root2) {
            if (root1 < root2) {
                parents[root2] = root1;
            } else {
                parents[root1] = root2;
            }
        }
    }

    static int findParent(int num){
        if(num ==parents[num]){
            return num;
        }
        return findParent(parents[num]);
    }
}
