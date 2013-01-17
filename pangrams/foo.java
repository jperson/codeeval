import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

class pangrams {
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
		SortedSet<Character> s = new TreeSet<Character>();
		
		while(scan.hasNextLine()) {
			char[] content = scan.nextLine().toCharArray();
			Arrays.sort(content);
			s.addAll(Character.);
		}

		Collections.sort(lines, new Comparator<String>() {
			public int compare(String l1, String l2) {
				Integer c1 = l1.length();
				Integer c2 = l2.length();
				return c2.compareTo(c1);
			}
		});
		
		for(int i = 0; i < n; i++) {
			System.out.println(lines.get(i));
		}
	}
}