import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCase = Integer.parseInt(br.readLine());

        while (totalCase-- >0){
            Queue<int[]> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n= Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int count =0 ;

            for(int i = 0; i < n; i++){
                q.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            while(!q.isEmpty()){
                int[] temp = q.poll();
                boolean print = true;
                for(int [] test : q){
                    if(temp[1]<test[1]){
                        print=false;
                        break;
                    }
                }
                if(print){
                    count++;
                    if(temp[0]==m){
                        System.out.println(count);
                        break;
                    }
                }else{
                    q.offer(temp);
                }
            }
        }
    }
}