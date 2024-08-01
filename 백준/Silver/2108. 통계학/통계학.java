import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        //산술평균
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        
        //범위
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        //최빈
        int[] arr = new int[8001];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            list.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
            arr[num + 4000]++;
        }
        
        Collections.sort(list);
        
        //최빈값
        int count = 0;
        List<Integer> modeList = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (arr[i] > count) {
                count = arr[i];
                modeList.clear();
                modeList.add(i - 4000);
            } else if (arr[i] == count) {
                modeList.add(i - 4000);
            }
        }
        
        //출력
        System.out.println(Math.round((double) sum / n));
        System.out.println(list.get((n - 1) / 2));
        System.out.println(modeList.size() > 1 ? modeList.get(1) : modeList.get(0));
        System.out.println(max - min);
    }
}
