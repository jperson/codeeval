import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class fizzbuzz {
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
			String[] v = scan.nextLine().split(" ");
			if(v.length == 3 && v[0].length() > 0 && v[1].length() > 0 && v[2].length() > 0) {
				fb(Integer.parseInt(v[0]), Integer.parseInt(v[1]), Integer.parseInt(v[2]));
			}
		}
	}
	
	private static void fb(int a, int b, int n) {
		String out = "";
		for(int i = 1; i <= n; i++) {
			if(i % a == 0 && i % b == 0) {
				out += "FB ";
			}
			else if(i % a == 0) {
				out += "F ";
			}
			else if(i % b == 0) {
				out += "B ";
			}
			else {
				out = out + i + " ";
			}
		}
		System.out.println(out.substring(0,out.length()-1));
	}
}