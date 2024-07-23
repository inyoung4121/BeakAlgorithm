import java.io.*;
import java.util.StringTokenizer;

//백트래킹
public class Main {
    static boolean[] visited = new boolean[26];
    static String[] str;
    static int max = Integer.MIN_VALUE;
    static int n,m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        str = new String[n];
        for(int i = 0; i < n; i++) {
            str[i] = br.readLine().replaceAll("a","")
                    .replaceAll("c","")
                    .replaceAll("i","")
                    .replaceAll("n","")
                    .replaceAll("t","");
        }
        visited['a'-'a']=true;
        visited['c'-'a']=true;
        visited['i'-'a']=true;
        visited['n'-'a']=true;
        visited['t'-'a']=true;
        if(m < 5){
            System.out.println(0);
            return;
        }else if(m == 26){
            System.out.println(n);
            return;
        }
        else{
            dfs(0,0);
        }
        System.out.println(max);
    }

    static void dfs(int depth, int start){
        if(depth == m-5){

            int count =0;
            for(int i = 0; i < n; i++){
                boolean canRead = true;

                for(int j = 0; j < str[i].length(); j++){
                    if(!visited[str[i].charAt(j)-'a']){
                        canRead = false;
                    }
                }

                if(canRead) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for(int i = start; i < 26; i++){
            if(visited[i]){continue;}
            visited[i]=true;
            dfs(depth+1, i+1);
            visited[i]=false;
        }
    }
}
