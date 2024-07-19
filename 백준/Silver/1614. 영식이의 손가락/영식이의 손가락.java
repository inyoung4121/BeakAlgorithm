import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long finger = Integer.parseInt(br.readLine()) -1 ;
        long count = Long.parseLong(br.readLine());

        if(count > 0 ){
            if(finger % 4 ==0) {
                finger += 8*count;
            }
            else {
                if(count % 2 ==0){
                    finger += 4*count;
                }
                else{
                    finger = 4*count + (4-finger);
                }
            }
        }

        System.out.println(finger);
    }
}
