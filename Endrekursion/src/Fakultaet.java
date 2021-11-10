
public class Fakultaet {


	private static long start; 
	private static long end; 
	
	private static int sum = 1200; 
	private static int faku = 55; 
	private static int pow = 55; 
	
	public static void main(String[] args) {
		System.out.print("Summe rekursiv: ");
		start = System.nanoTime();
		long summeRekursiv = sum(sum);
		end = System.nanoTime();
		System.out.println(summeRekursiv + ", berechnet in " + (end - start) / 1000 + " Millisekunden");

		System.out.print("Summe endrekursiv: ");
		start = System.nanoTime();
		long summeEndrekursiv = endSum(0, sum);
		end = System.nanoTime();
		System.out.println(summeEndrekursiv + ", berechnet in " + (end - start) / 1000 + " Millisekunden");

		System.out.print("Fakultät rekursiv: ");
		start = System.nanoTime();
		long fakRekursiv = faku(faku);
		end = System.nanoTime();
		System.out.println(fakRekursiv + ", berechnet in " + (end - start) / 1000 + " Millisekunden");

		System.out.print("Fakultät endrekursiv: ");
		start = System.nanoTime();
		long fakEndRekursiv = endFaku(1, faku);
		end = System.nanoTime();
		System.out.println(fakEndRekursiv + ", berechnet in " + (end - start) / 1000 + " Millisekunden");

		System.out.print("Hochfunktion rekursiv: ");
		start = System.nanoTime();
		long powfakRekursiv = powfak(2, pow);
		end = System.nanoTime();
		System.out.println(powfakRekursiv + ", berechnet in " + (end - start) / 1000 + " Millisekunden");

		System.out.print("Hochfunktion endrekursiv: ");
		start = System.nanoTime();
		long powfakEndrekursiv = endPowfak(1, 2, pow);
		end = System.nanoTime();
		System.out.println(powfakEndrekursiv + ", berechnet in " + (end - start) / 1000 + " Millisekunden");

	}

	public static long sum(int zahl) {
		if (zahl >= 1) {
			return zahl + sum(zahl - 1);
		}

		return 0;
	}

	public static long endSum(long sum, int zahl) {
		if (zahl == 0) {
			return sum;
		}
		return endSum(sum + zahl, zahl - 1);
	}

	public static long faku(int zahl) {
		if (zahl >= 1) {
			return zahl * faku(zahl - 1);
		}
		return 1;

	}

	public static long endFaku(long prod, int zahl) {
		if (zahl == 0) {
			return prod;
		}
		return endFaku(prod * zahl, zahl - 1);
	}

	public static long powfak(int basis, int exponent) {
		if (exponent >= 1) {
			return basis * powfak(basis, exponent - 1);
		}
		return 1;
	}

	public static long endPowfak(long prod, int basis, int exponent) {
		if (exponent == 0) {
			return prod;
		}
		return endPowfak(prod * basis, basis, exponent - 1);
	}
}