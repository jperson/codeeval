import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class multiples {
	public static void main(String[] args) throws IOException {
		if(1 != args.length) {
			System.out.println("Usage: <file>");
			System.exit(1);
		}
		File f = new File(args[0]);
		if(!f.exists() || !f.isFile()) {
			System.out.println("Not a valid file.");
			System.exit(2);
		}
		process(f);
	}
	
	private static void process(File f) throws IOException {
		FileReader fr = new FileReader(f);
		Scanner scan = new Scanner(fr);
		
		while(scan.hasNextLine()) {
			String[] l = scan.nextLine().split(",");
			if(l.length > 0 && l[0].length() > 0) {
				int x = Integer.parseInt(l[0]);
				int n = Integer.parseInt(l[1]);
				
				while(n < x) {
					n += n;
				}
				System.out.println(n);
			}
		}
	}
}