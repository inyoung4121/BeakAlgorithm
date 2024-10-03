
import java.io.*;
import java.util.ArrayList;

public class Main {
	
	static char [][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int leng = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		map = new char[5][leng/5];
		
		for(int i = 0; i<5; i++){
			map[i] = str.substring(i*leng/5,leng/5*(i+1)).toCharArray();
		}
		
		
		ArrayList<Integer> list = new ArrayList<>();
		
		
		for(int i = 0; i<leng/5; i++){
			
			if(map[0][i] == '#'){
				
				if(i+2 <= leng/5){ 
					if(map[0][i+1] == '#' && map[0][i+2] == '#'){
						
						list.add(choice(i)); 
						
						i = i+3;
					
						if(i >= leng/5) break; 
						
						continue; 
					}
				}

				if(map[3][i] == '#') list.add(1); //(3,i)가 '#'이면 1을
				else{ 
					list.add(4);
					i = i+3;
					if(i >= leng/5) break;
				}

			}

		}
		
		for(int n : list){
			System.out.print(n);
		}
		
	}
	
	private static int choice(int x){
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i<5; i++){
			for(int j = 0; j<3; j++){
				sb.append(map[i][j+x]);
			}
		}
		
		return check(sb.toString());
	}
	
	private static int check(String sb){
		
		int result = 10;
		String [] num = new String[10];
		
		num[0] = "####.##.##.####";
		num[2] = "###..#####..###";
		num[3] = "###..####..####";
		num[5] = "####..###..####";
		num[6] = "####..####.####";
		num[7] = "###..#..#..#..#";
		num[8] = "####.#####.####";
		num[9] = "####.####..####";
		
		for(int i = 0; i<num.length; i++){
			if(sb.equals(num[i])){
				result = i;
				break;
			}
		}
		return result;
	}
}

