import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class position {
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
		
		while(scan.hasNextLine()) {
			String[] ns = scan.nextLine().split(",");
			if(ns.length > 0 && ns[0].length() > 0) {
				int n = Integer.parseInt(ns[0]);
				int p1 = Integer.parseInt(ns[1]) - 1;
				int p2 = Integer.parseInt(ns[2]) - 1;
				
				if(((n >> p1) & 1) == ((n >> p2) & 1)) {
					System.out.println("true");
				}
				else {
					System.out.println("false");
				}
			}
		}
	}
}