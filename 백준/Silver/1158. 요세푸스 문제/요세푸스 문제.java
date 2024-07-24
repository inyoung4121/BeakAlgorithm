import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(i+1);
		}

		int n = 1;
		int idx = (K*n-1) % list.size();
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		while(N-- > 0){
			
			sb.append(list.remove(idx)).append(", ");
			
			if(list.isEmpty()) break;
			
			idx = (idx + K - 1) % list.size();
			n++;
		}
		String str = sb.substring(0, sb.length()-2);
		System.out.print(str);
		System.out.print('>');
		
	}
}