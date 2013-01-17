import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class prime_less {
	public static void main(String[] args) throws IOException {
		if(1 != args.length) {
			System.out.println("Usage: <file>");
			System.exit(0);
		}
		
		File f = new File(args[0]);
		if(!f.exists() || !f.isFile()) {
			System.out.println(args[0] + " is not a valid file");
		}
		
		process(f);
	}
	
	private static void process(File f) throws IOException {
		FileReader fr = new FileReader(f);
		Scanner scan = new Scanner(fr);
		
		while(scan.hasNextInt()) {
			int v = scan.nextInt();
			sieve(v);
		}
	}
	
	private static void sieve(int n) {
		boolean[] composite = new boolean[n+1];
		int n_sqrt = (int)Math.sqrt(n) + 1;
		String out = "";
		
		for(int i = 2; i < n_sqrt; i++) {
			if(!composite[i]) {
				out = out + i + ",";
				for(int j = i*i; j <= n; j+=i) {
					composite[j] = true;
				}
			}
		}
		for(int i = n_sqrt; i < n; i++) {
			if(!composite[i]) {
				out = out + i + ",";
			}
		}
		
		System.out.println(out.substring(0, out.length()-1));
	}
}