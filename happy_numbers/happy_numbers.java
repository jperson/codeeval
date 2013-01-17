import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class happy_numbers {
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
			String v = scan.next();
			happy(v);
		}
	}
	
	private static void happy(String n) {
		Set<Integer> numbers = new HashSet<Integer>();
		
		Integer sum = 0;
		int c = 0;
		
		while(true) {
			for(int i = 0; i < n.length(); i++) {
				c = Integer.parseInt(n.substring(i,i+1));
				sum = sum + c*c;
			}
			if(1 == sum) {
				System.out.println("1");
				break;
			}
			else if(numbers.contains(sum)) {
				System.out.println("0");
				break;
			}
			numbers.add(sum);
			n = sum.toString();
			sum = 0;
		}
	}
}