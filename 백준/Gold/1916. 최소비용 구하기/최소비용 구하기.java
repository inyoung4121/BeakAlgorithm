import java.io.*;
import java.util.*;

public class Main {
    private static final int BUF_SIZE = 1 << 13;
    private static final byte[] buf = new byte[BUF_SIZE];
    private static int cursor = -1, end;
    private static byte read() throws IOException {
        if (++cursor == end) {
            end = System.in.read(buf, 0, BUF_SIZE);
            cursor = 0;
        }
        return buf[cursor];
    }
    
    private static int readInt() throws IOException {
        int res = 0;
        int in = read();
        while (in > 32) {
            res = (res << 3) + (res << 1) + (in & 15);
            in = read();
        }
        return res;
    }
    
    private static int[] distance;
    private static int[][] graph;
    
    private static int[] vHeap;
    private static int[] dHeap;
    private static int size;
    
    private static void push(int v, int dist) {
        int pos = ++size;
        while (pos > 1) {
            if (dHeap[pos >> 1] <= dist)
                break;
            dHeap[pos] = dHeap[pos >> 1];
            vHeap[pos] = vHeap[pos >> 1];
            pos >>= 1;
        }
        
        dHeap[pos] = dist;
        vHeap[pos] = v;
        return;
    }
    
    private static void pop() {
        if (size == 1) {
            size = 0;
            return;
        }
        
        int parent = 1;
        int child = 1;
        while ((child <<= 1) <= size) {
            if (child + 1 <= size && dHeap[child] > dHeap[child + 1])
                ++child;
            
            if (dHeap[child] >= dHeap[size])
                break;
            
            dHeap[parent] = dHeap[child];
            vHeap[parent] = vHeap[child];
            parent = child;
        }
        
        dHeap[parent] = dHeap[size];
        vHeap[parent] = vHeap[size--];
        return;
    }
    
    public static void main(String[] args) throws IOException {
        final int n = readInt();
        int m = readInt();
        
        graph = new int[n + 1][n + 1];
        distance = new int[n + 1];
        vHeap = new int[m + 1];
        dHeap = new int[m + 1];
        
        for (int i = 1; i <= n; i++)
            distance[i] = 100000000;
        
        while (--m != -1) {
            final int from = readInt();
            final int to = readInt();
            final int cost = readInt();
            if (graph[from][to] == 0 || graph[from][to] > cost + 1)
                graph[from][to] = cost + 1;
        }
        
        final int start = readInt();
        final int end = readInt();
        
        distance[start] = 0;
        push(start, 0);
        
        while (size != 0) {
            int current = vHeap[1];
            int cost = dHeap[1];
            pop();
            
            if (cost > distance[current])
                continue;
            
            for (int i = 1; i <= n; i++) {
                if (graph[current][i] != 0 && distance[i] >= distance[current] + graph[current][i]) {
                    distance[i] = distance[current] + graph[current][i] - 1;
                    push(i, distance[i]);
                }
            }
        }
        
        System.out.print(distance[end]);
    }
}