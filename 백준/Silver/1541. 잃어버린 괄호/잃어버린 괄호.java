import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] tmp = str.split("-");
        int sum =0;
        for(String st : tmp[0].split("\\+")){
            sum+=Integer.parseInt(st);
        }
        for( int i =1;i<tmp.length;i++){
            for(String st : tmp[i].split("\\+")){
                sum-=Integer.parseInt(st);
            }
        }
        System.out.println(sum);
    }
}

//23588	288