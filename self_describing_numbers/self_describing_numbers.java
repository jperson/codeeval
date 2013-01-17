import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class self_describing_numbers {
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
			self_describing(v);
		}
	}
	
	private static void self_describing(String n) {
		int[] numbers = new int[10];
		int c = 0;
		boolean self_describing = true;
		
		for(int i = 0; i < n.length(); i++) {
			c = Integer.parseInt(n.substring(i,i+1));
			numbers[c]++;
		}
		for(int i = 0; i < n.length(); i++) {
			c = Integer.parseInt(n.substring(i,i+1));
			if(c != numbers[i]) {
				self_describing = false;
				break;
			}
		}
		if(self_describing) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}
}