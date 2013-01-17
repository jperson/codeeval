import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class fibonacci {
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
			int i = scan.nextInt();
			System.out.println(fib(i));
		}
	}
	
	private static int fib(int n) {
		if(n > 1) {
			int[] f = new int[n+1];
			f[0] = 0; f[1] = 1;
			for(int i = 2; i <= n; i++) {
				f[i] = f[i-1] + f[i-2];
			}
			
			return f[n];
		}
		else {
			return n;
		}
	}
}