import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class stack {
	public static void main(String[] args) throws IOException {
		if(1 != args.length) {
			System.out.println("Usage: <file>");
			System.exit(0);
		}
		
		File f = new File(args[0]);
		if(!f.exists() || !f.isFile()) {
			System.out.println(args[0] + " is not a valid file");
		}
		
		stack s = new stack();
		s.process(f);
	}
	
	public void process(File f) throws IOException {
		FileReader fr = new FileReader(f);
		Scanner scan = new Scanner(fr);
		
		while(scan.hasNextLine()) {
			String[] v = scan.nextLine().split(" ");
			if(v.length > 0 && v[0].length() > 0) {
				for(String n : v) {
					push(Integer.parseInt(n));
				}
				
				Integer e;
				while(size() > 0) {
					e = pop();
					System.out.print(e + " ");
					if(size() > 0) pop();
					else break;
				}
				System.out.println();
			}
		}
	}
	
	public stack() {
		m_stack = new LinkedList<Integer>();
	}
	
	public void push(Integer e) {
		m_stack.add(0, e);
	}
	
	public Integer pop() {
		return m_stack.remove(0);
	}
	
	public Integer size() {
		return m_stack.size();
	}
	
	private List<Integer> m_stack;
}