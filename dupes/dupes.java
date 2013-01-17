import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class dupes {
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
			String[] v = scan.nextLine().split(",");
			if(v.length > 0 && v[0].length() > 0) {
				dupe(v);
			}
		}
	}
	
	private static void dupe(String[] values) {
		int[] dupes = new int[Integer.parseInt(values[values.length-1]+1)];
		String out = "";
		for(String w : values) {
			int n = Integer.parseInt(w);
			dupes[n] += 1;
		}
		int i = 0;
		for(;i < dupes.length-1; i++) {
			if(dupes[i] > 0) {
				out += i;
				break;
			}
		}
		for(i++;i < dupes.length-1;i++) {
			if(dupes[i] > 0) {
				out = out + "," + i;
			}
		}
		System.out.println(out);
	}
}