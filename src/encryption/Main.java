package encryption;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	Encrypt encrypt = new Encrypt();
	
	public void showMenu() {
		System.out.println("1. Encrypt");
		System.out.println("2. Decrypt");
		System.out.println("3. Exit");
	}

	public Main() {
		int choice = 0;;
		do {
		showMenu();
		System.out.println(">> ");
		try {
			choice = scan.nextInt(); scan.nextLine();
		} catch (Exception e) {
			choice = -1;
			scan.nextLine();
		}
		if(choice==1) {
			String plaintext;
			int flag = -1;
			do {
			System.out.println("Enter a plaintext [a-z only]: ");
			plaintext = scan.nextLine();
			if(Pattern.matches("[a-zA-Z]+", plaintext)) {
				flag = 1;
			}
			else {
				flag = -1;
			}
			} while(flag == -1);
			plaintext = plaintext.toUpperCase();
			String ciphertext = encrypt.enkripsi(plaintext);
			System.out.println("Ciphertext: "+ciphertext);
		}
		else if(choice==2) {
			String ciphertext;
			int flag2 = -1;
			do {
			System.out.println("Enter a ciphertext [a-z and numbers only]: ");
			ciphertext = scan.nextLine();
			if(Pattern.matches("[a-zA-Z0-9]+", ciphertext)) {
				flag2 = 1;
			}
			else {
				flag2 = -1;
			}
			} while(flag2 != 1);
			ciphertext = ciphertext.toUpperCase();
			String plaintext = encrypt.dekripsi(ciphertext);
			System.out.println("Plaintext: "+plaintext);
		}
		else if(choice==3) {
			System.out.println("Exit the system");
		}
		} while(choice != 3);
	}

	public static void main(String[] args) {
		new Main();
	}

}
