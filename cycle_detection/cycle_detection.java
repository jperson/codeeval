import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cycle_detection {
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
		List<Integer> l = new ArrayList<Integer>();
		
		while(scan.hasNextLine()) {
			int max = 0;
			String[] v = scan.nextLine().split(" ");
			if(v.length > 0 && v[0].length() > 0) {
				for(String n : v) {
					int x = Integer.parseInt(n);
					l.add(x);
					if(x > max) max = x;
				}
				
				cycle_detect(l, max);
				l.clear();
			}
		}
	}
	
	private static void cycle_detect(List<Integer> list, int size) {
		int[] g = new int[size+1];
		for(int i = 0; i < list.size() - 1; i++) {
			g[list.get(i)] = list.get(i+1);
		}
	
		int t = g[list.get(0)];
		int h = g[g[list.get(0)]];
		
		while(t != h) {
			t = g[t];
			h = g[g[h]];
		}
		
		int mu = 0;
		t = list.get(0);
		while(t != h) {
			t = g[t];
			h = g[h];
			mu++;
		}
		
		int lam = 1;
		h = g[t];
		while (t != h) {
			h = g[h];
			lam++;
		}
		
		if(lam > 1) {
			String out = "";
			for(Integer x : list.subList(mu, mu+lam)) {
				out = out + x + " ";
			}
			System.out.println(out.substring(0, out.length() - 1));
		}
	}
}