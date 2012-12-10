import java.util.Random;

public class ExTimes {
	
	public ExTimes() {
		
	}
	
	public static void main(String[] args) {
		primeTesting();
		/*
		int n = 100;
		int sum = 0;
		
		// Fragment #1
		for ( int i = 0; i < n; i ++) 
		    sum++;
		
		System.out.println("Fragment #1 für n = " + n + ": " + sum);
		sum = 0;
		
		// Fragment #2
		for ( int i = 0; i < n; i ++) 
		    for ( int j = 0; j < n; j ++) 
		        sum++;
		
		System.out.println("Fragment #2 für n = " + n + ": " + sum);
		sum = 0;
		
		// Fragment #3
		for ( int i = 0; i < n; i ++) 
		    for ( int j = i; j < n; j ++) 
		        sum++;
		
		System.out.println("Fragment #3 für n = " + n + ": " + sum);
		sum = 0;

		
		// Fragment #4
		for ( int i = 0; i < n; i ++) 
		    sum ++; 
		    for ( int j = 0; j < n; j ++) 
		        sum ++;
		
		System.out.println("Fragment #4 für n = " + n + ": " + sum);
		sum = 0;

		
		// Fragment #5
		for ( int i = 0; i < n; i ++) 
		    for ( int j = 0; j < n*n; j ++) 
		    sum++;

		System.out.println("Fragment #5 für n = " + n + ": " + sum);
		sum = 0;
		
		// Fragment #6
		for ( int i = 0; i < n; i ++) 
		    for ( int j = 0; j < i; j ++) 
		        sum++;
		
		System.out.println("Fragment #6 für n = " + n + ": " + sum);
		sum = 0;
		
		// Fragment #7
		for ( int i = 1; i < n; i ++)
		    for ( int j = 0; j < n*n; j ++) 
		        if (j % i == 0) 
		           for (int k = 0; k < j; k++) 
		               sum++;
		
		System.out.println("Fragment #7 für n = " + n + ": " + sum + "\n-\n");
		sum = 0;
		*/
	}
	
	public static void primeTesting() {
		Random r = new Random();
		System.out.println("100x 20-bit number testing:");
		for(int i = 0; i < 100; i++) {
			int number =  r.nextInt((int) Math.pow(20, 2));
			isPrime(number);
		}
		System.out.println("100x 40-bit number testing:");
		for(int i = 0; i < 100; i++) {
			int number =  r.nextInt((int) Math.pow(40, 2));
			isPrime(number);
		}
	}
	
	public static boolean isPrime (int n) {
		int sum = 1;
		if (n <= 1) {
            System.out.println(sum + " false");
            return false;
        }
        if (n == 2) {
            System.out.println(sum + " true");
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
        	sum++;
            if (n % i == 0) {
                System.out.println(sum + " false");
                return false;
            }
        }
        System.out.println(sum + " true");
        return true;
	}
}
