import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class sum_digits {
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
		
		while(scan.hasNext()) {
			int x = scan.nextInt();
			int sum = x % 10;
			while(0 < (x /= 10)) {
				sum += x % 10;
			}
			System.out.println(sum);
		}
	}
}