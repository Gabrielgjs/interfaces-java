package application;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program1 {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Enter contract data: ");
		System.out.print("Number: ");
		Integer number = scan.nextInt();
		System.out.print("Date(dd/MM/yyyy): ");
		Date date =  sdf.parse(scan.next());
		System.out.print("Contract value: ");
		Double totalValue = scan.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		System.out.print("Enter number of installments: ");
		int N = scan.nextInt();
		
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, N);
		System.out.println("Installments: ");
		for(Installment it : contract.getInstallments()) {
			System.out.println(it);
		}
		
		scan.close();
	}
}
