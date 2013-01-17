import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class longestlines {
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
		List<String> lines = new ArrayList<String>();
		String line = "";
		int n = 0;
		
		if(scan.hasNextInt()) {
			n = scan.nextInt();
			while(scan.hasNextLine()) {
				line = scan.nextLine().trim();
				if(line.length() > 0) {
					lines.add(line);
				}
			}
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