import java.io.*;
import java.util.*;

class problem implements Comparable<problem> {
    int l;
    int p;
    public problem(int l, int p){
        this.l = l;
        this.p = p;
    }

    @Override
    public int compareTo(problem o) {
        if(this.l == o.l){
            return this.p - o.p;
        }
        return this.l - o.l;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        TreeSet<problem> set = new TreeSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            set.add(new problem(l, p));
            map.put(p,l);
        }


        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "recommend":
                    if(Integer.parseInt(st.nextToken())==1){
                        sb.append(set.last().p).append("\n");
                    }else{
                        sb.append(set.first().p).append("\n");
                    }
                    break;
                case "add" :
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    set.add(new problem( l,p));
                    map.put(p,l);
                    break;
                case "solved" :
                    int rP = Integer.parseInt(st.nextToken());
                    int rL = map.get(rP);
                    set.remove(new problem(rL,rP));
                    map.remove(rP);
            }
        }
        System.out.println(sb);
    }
}
