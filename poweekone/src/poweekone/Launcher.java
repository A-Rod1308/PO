package poweekone;

import java.util.Scanner;

public class Launcher {
	
	public static void main(String[] args) {
		
		boolean menu = true;
		Scanner sc = new Scanner(System.in);
		
		while(menu) {
			System.out.println("\n\nEnter Option:\n1) Encript using Rot13?\n2) Convert Decimal to Octal\n3) Exit...");
			String in = sc.nextLine();
			
			switch(in) {
				case "1":
					encript();
					break;
				case "2":
					convert();
					break;
				case "3":
					System.exit(0);
					break;
				default :
					System.out.println("Try again:\n\n");
					break;
			}
			
		}
		
	}
	
	public static void encript() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter message to encript:\n");
		String msg = sc.nextLine();
		char[] characters = msg.toCharArray();
		System.out.println("\nYour message:");
		for (char c : characters) {
			System.out.print(c-=13);
		}
			
		
		
	}
	
	public static void convert() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter decimal to convert to octal:\n");
		Integer msg = Integer.parseInt(sc.nextLine(),8);
		
		
		System.out.println("\nYour message:");
		System.out.println(msg);
		
	}

}
