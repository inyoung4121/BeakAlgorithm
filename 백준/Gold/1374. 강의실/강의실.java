import java.io.*;
import java.util.*;

class Study implements Comparable<Study> {
    int start;
    int end;

    public Study(int start, int end){
        this.start = start;
        this.end = end;
    }


    @Override
    public int compareTo(Study o) {
        if(start==o.start){return end-o.end;}
        return start-o.start;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Study> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]);
            pq.add(new Study(start, end));
        }

        int max = 1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();

        while (!pq.isEmpty()){
            while (!pq1.isEmpty() && pq1.peek()<=pq.peek().start){
                pq1.poll();
            }
            pq1.offer(pq.poll().end);
            max = Math.max(max, pq1.size());
        }


        System.out.println(max);
    }
}