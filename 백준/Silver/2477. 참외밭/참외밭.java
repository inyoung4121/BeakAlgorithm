

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//>>> 가로세로 최대값이 나온 후 2번 뒤에 반드시 빼야하는 길이가 나온다. >> 최대가로값의 인덱스 +3 은 빼야하는 세로값 을 사용하면 간편하게 구현 할 수 있을듯..
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int yieldPerUnit = Integer.parseInt(st.nextToken());
        int[] direction = new int[6];
        int[] lengths = new int[6];
        int maxWidth = 0; int maxHeight = 0;
        int maxWidthIdx = 0; int maxHeightIdx = 0;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            direction[i] = Integer.parseInt(st.nextToken());
            lengths[i] = Integer.parseInt(st.nextToken());

            if(direction[i] <3 && maxWidth < lengths[i]){
                maxWidth = lengths[i];
                maxWidthIdx = i;
            }else if(direction[i] > 2 && maxHeight < lengths[i]){
                maxHeight = lengths[i];
                maxHeightIdx = i;
            }
        }
        int minusHidth = lengths[(maxWidthIdx+3)%6];
        int minusWidth = lengths[(maxHeightIdx+3)%6];
        int minusArea = minusHidth * minusWidth;

        System.out.println((maxHeight*maxWidth-minusArea)*yieldPerUnit);

    }
}
