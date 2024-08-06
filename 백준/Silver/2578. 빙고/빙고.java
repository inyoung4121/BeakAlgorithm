import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[5][5];
        boolean[][] visited = new boolean[5][5];
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count=0;
        boolean leftCheck =false;
        boolean rightCheck =false;
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                for(int k = 0; k < 5; k++) {
                    for(int l = 0; l < 5; l++) {
                        if(arr[k][l] == num) {
                            visited[k][l] = true;
                            if(visited[k][0]==true&&visited[k][1]==true&&visited[k][2]==true&&visited[k][3]==true&&visited[k][4]==true) {count++;}
                            if(visited[0][l]==true&&visited[1][l]==true&&visited[2][l]==true&&visited[3][l]==true&&visited[4][l]==true) {count++;}
                        }
                    }
                }
                if(!leftCheck&&visited[0][0]==true&&visited[1][1]==true&&visited[2][2]==true&&visited[3][3]==true&&visited[4][4]==true){
                    leftCheck=true;
                    count++;
                }
                if(!rightCheck&&visited[4][0]==true&&visited[3][1]==true&&visited[2][2]==true&&visited[1][3]==true&&visited[0][4]==true){
                    rightCheck=true;
                    count++;
                }
                if(count>=3){
                    System.out.println(i*5 + j+1);
                    return;
                }
            }
        }
    }

}
