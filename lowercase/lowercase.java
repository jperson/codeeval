import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class lowercase {
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
			System.out.println(scan.nextLine().toLowerCase());
		}
	}
}