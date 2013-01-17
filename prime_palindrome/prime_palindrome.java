import java.util.Vector;

public class prime_palindrome {
	public static void main(String[] args) {
		int max = 0;
		for(Integer p : primes(1000)) {
			if(isPalindrome(p.toString())) {
				max = p;
			}
		}
		
		System.out.println(max);
	}
	
	private static boolean isPalindrome(String s) {
		int i = 0; int j = s.length()-1;
		while(i <= j) {
			if(s.charAt(i) != s.charAt(j)) {
				break;
			}
			i++; j--;
		}
		return (i > j);
	}
	private static Vector<Integer> primes(int max) {
		Vector<Integer> p = new Vector<Integer>();
		int count = 1;
		int n = 3;
		
		p.add(0,2);

		while(count < max) {
			boolean isPrime = true;
			for(Integer x : p) {
				if(0 == (n % x)) {
					isPrime = false;
					break;
				}
				if(Math.sqrt(n) < x) {
					break;
				}
			}
			if(isPrime) {
				p.add(n);
				count++;
			}
			n+=2;
		}
		
		return p;
	}
}