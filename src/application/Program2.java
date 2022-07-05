package application;

import java.util.Locale;
import java.util.Scanner;

import model.services.InterestService;
import model.services.UsaInterestService;

public class Program2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Amount: ");
		double amount = scan.nextDouble();
		System.out.print("Monhts: ");
		int months = scan.nextInt();
		
		InterestService is = new UsaInterestService(1.0);
		double payment = is.payment(amount, months);
		
		System.out.println("Payment after " + months + "months: ");
		System.out.println(String.format("%.2f", payment));
	}

}
