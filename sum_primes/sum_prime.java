import java.util.Vector;


public class sum_prime {
	public static void main(String[] args) {
		int sum = 0;
		for(Integer p : primes(1000)) {
			sum += p;
		}
		
		System.out.println(sum);
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