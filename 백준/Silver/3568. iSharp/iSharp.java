
import java.io.*;
import java.util.*;
public class Main {
    static String str[];
    static String ans[];
    static String std="";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] t = br.readLine().split(" ");
        std+=t[0];
        
        str = new String[t.length-1];
        ans = new String[t.length-1];    // 최종답
        for(int i=0; i<str.length; i++) {
            str[i] = t[i+1];
        }        // 가독성을 위해서 새로운 str배열에 담아줌
        
        
        
        for(int i=0; i<str.length; i++) {
            String tmp="";    // 여기다가 답을 담을것
            String alpha=" ";        // 변수의 이름을 담을 것
            for(int j=str[i].length()-1; j>=0; j--) {    // 역순으로 진행
                if(str[i].charAt(j)==',' || str[i].charAt(j)==';') {    // 답을 구성할때 필요없는것들은 skip
                    continue;
                }
                if(str[i].charAt(j)==']') {        //역순으로 저장할 경우 ][  이런식으로 저장됨으로 처리를 해준다.
                    tmp+="[]";    
                    j--;
                    continue;
                }
                if(end(str[i].charAt(j))) {
                    for(int k=0; k<=j; k++) {
                        alpha+=str[i].charAt(k);
                    }
                    alpha+=";";
                    break;
                }
                tmp+=str[i].charAt(j);
            }
            ans[i] = std+tmp+alpha;
        }
        for(int i=0; i<ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
    public static boolean end(char c) {
        if(c!='*' && c!='&' && c!='[' && c!=']') {
            return true;
        }
        return false;
    }
}
