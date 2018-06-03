import java.util.Scanner;

class rsa {

	static int gcd(int a, int b) {
		return (b == 0 ? a : gcd(b, a % b));
	}

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		System.out.println("enter the msg to be encrypted\n");
		String message = scan.nextLine();
		int size = message.length();
		int num[] = new int[size];
		int p = 0, q = 0, n = 0, e = 0, d = 0, phi = 0;
		int enc[] = new int[size];
		int dec[] = new int[size];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) message.charAt(i);
		}

		System.out.println("enter value of p and q\n");
		p = scan.nextInt();
		q = scan.nextInt();
		System.out.println("P and Q" + p + " " + q);
		n = p * q;
		phi = (p - 1) * (q - 1);
		for (int i = 2; i < phi; i++) {
			e = i;
			if (gcd(i, phi) == 1)
				break;

		}
		System.out.println("eis " + e);
		for (int k = 2; k < phi; k++) {
			d = k;
			if ((e * k ) % phi == 1)
				break;
		}

		System.out.println("dis " + d);
		for (int i = 0; i < num.length; i++) {
			enc[i] = 1;
			for (int j = 0; j < e; j++) {
				enc[i] = (enc[i] * num[i]) % n;
			}
		}
		for (int i = 0; i < num.length; i++) {
			System.out.println("Encrypted  msg is \n");
			System.out.println(enc[i]);
		}
		for (int i = 0; i < num.length; i++) {
			dec[i] = 1;
			for (int j = 0; j < d; j++)
				dec[i] = (dec[i] * enc[i]) % n;
		}
		System.out.println("decrypted msg is \n");
		for (int i = 0; i < num.length; i++) {
			System.out.println((char) dec[i]);
		}
	}

}
