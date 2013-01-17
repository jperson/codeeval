import java.io.File;

public class filesize {
	public static void main(String[] args){
		if(1 != args.length) {
			System.out.println("Usage: <file>");
			System.exit(0);
		}
		
		File f = new File(args[0]);
		if(!f.exists() || !f.isFile()) {
			System.out.println(args[0] + " is not a valid file");
		}
		
		System.out.println(f.length());
	}
}