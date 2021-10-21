
public class Main {

	private static int counter;
	
	public static void main(String[] args) {
		int [] zahlen = {1, 2, 4, 7, 56, 77,3,45,545,66,64,76,88,99,43,234,565,657,878,989,7547};
	
		if(suche(44,zahlen)) {
			System.out.println("Gefunden");
		}else {
			System.out.println("Nicht gefunden");
		}
	
		System.out.println(counter);
	
	}

	
	public static boolean suche(int zahl, int [] meineListe) {
		for (int i = 0; i < meineListe.length; i++) {					//[] nur die Definition
			counter = i;

			if(meineListe[i] == zahl) {
				return true;
			}
			
		}
	
	return false;
	}

}
