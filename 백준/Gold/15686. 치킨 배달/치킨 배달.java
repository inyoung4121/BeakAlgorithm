import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//백트래킹
//치킨집중 m개를 뽑아 거리를 계산하고 최소값을 출력한다.
//계산을 편하게 하기 위해 리스트에 집,치킨집을 저장한다
public class Main {
    private static int n,m;
    private static List<int[]> chickens,house;
    private static boolean[] visited;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chickens = new ArrayList<>();
        house = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==1){house.add(new int[]{i,j});}
                if(tmp==2){chickens.add(new int[]{i,j});}
            }
        }

        visited = new boolean[chickens.size()];
        cal(0,0);
        System.out.println(result);
    }
    private static void cal(int depth,int start){

        if(depth==m){
            int sum =0;
            for (int[] ints : house) {
                int minDistance = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if(!visited[j]){continue;}
                    int distance = Math.abs(ints[0] - chickens.get(j)[0])
                            + Math.abs(ints[1] - chickens.get(j)[1]);
                    minDistance = Math.min(minDistance, distance);
                }
                sum += minDistance;
            }
            result = Math.min(result,sum);
            return;
        }

        for(int i=start;i< chickens.size();i++){
            if(visited[i]){continue;}
            visited[i]= true;
            cal(depth+1,i+1);
            visited[i]= false;
        }

    }
}