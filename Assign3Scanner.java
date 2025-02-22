package sammer_baja;
import java.text.DecimalFormat;
import java.util.*;

public class Assign3Scanner {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat d = new DecimalFormat("0.000");
		
	System.out.println("Enter first name: ");
		String firstName = input.next();
	System.out.println("Enter middle initial");
		String mid = input.next();
	System.out.println("Enter last name: ");
		String lastName = input.next();
	System.out.println("Enter monthly contribution: ");
		double contribution = input.nextDouble();
	System.out.println("Enter interest rate: ");
		int rate = input.nextInt();
	
	float annualContribution = (float)contribution * 12;
	double annualDividend = annualContribution * rate/100;
	
	char FirstInitials = firstName.charAt(0);
	char MidInitials = mid.charAt(0);
	char LastInitials = lastName.charAt(0);
	
	
	System.out.println("Fullname: "+firstName+" " +mid+" "+lastName);
	System.out.println("Initials: "+FirstInitials+" " +MidInitials+" "+LastInitials);
	System.out.println("Monthly Contribution: "+contribution +
			"\nInterest Rate: "+rate+
			"\nAnnual Contribution: "+d.format(annualContribution)+
			"\nAnnual Divident: "+d.format(annualDividend));
	
	input.close();

}

}
