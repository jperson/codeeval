import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class intersection {
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
		SortedSet<Integer> s1 = new TreeSet<Integer>();
		SortedSet<Integer> s2 = new TreeSet<Integer>();
		
		while(scan.hasNextLine()) {
			String[] v = scan.nextLine().split(";");
			if(v.length > 0 && v[0].length() > 0) {
				String out = "";
				s1.clear(); s2.clear();
				for(String w : v[0].split(",")) {
					s1.add(Integer.parseInt(w));
				}
				for(String w : v[1].split(",")) {
					s2.add(Integer.parseInt(w));
				}
				s1.retainAll(s2);
				for(Integer x : s1) {
					out = out + x + ",";
				}
				if(out.length() > 0)
				{
					out = out.substring(0, out.length() - 1);
					System.out.println(out);
				}
			}
		}
	}
}