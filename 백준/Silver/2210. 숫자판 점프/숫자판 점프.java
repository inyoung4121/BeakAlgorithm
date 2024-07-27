import java.io.*;
import java.util.*;

/*dfs문제.
* 깊이가 6이 될때까지 전방향 반복
* set을 사용해서 중복값 제거*/
public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Set<String> result = new HashSet<>();
    static int[][] arr = new int[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                get(0,i,j,"");
            }
        }

        System.out.println(result.size());
    }

    static void get(int depth, int x, int y, String str){
        if (depth == 6) {
            result.add(str);
            return;
        }
        str += arr[x][y];
        for(int i = 0;i<4;i++){
            if(isInBounds(x+dx[i],y+dy[i])) get(depth+1,x+dx[i],y+dy[i],str);
        }
    }

    static boolean isInBounds(int x,int y){
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}

