import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class array_absurdity {
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
			String[] test = scan.nextLine().split(";");
			if(test.length > 0 && test[0].length() > 0) {
				int sum = 0;
				int max = Integer.parseInt(test[0]) - 2;
				max = (max * (max+1))/2;
				for(String w : test[1].split(",")) {
					sum += Integer.parseInt(w);
				}
				System.out.println(sum-max);
			}
		}
	}
}