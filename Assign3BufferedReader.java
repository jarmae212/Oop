package sammer_baja;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
public class Assign3BufferedReader {
	public static void main(String[] args) throws IOException {
		BufferedReader  input = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat d = new DecimalFormat("0.000");
		
		System.out.println("Enter first name: ");
			String firstName = input.readLine();
		System.out.println("Enter middle initial");
			String mid = input.readLine();
		System.out.println("Enter last name: ");
			String lastName = input.readLine();
		System.out.println("Enter monthly contribution: ");
			double contribution = Double.parseDouble(input.readLine());
		System.out.println("Enter interest rate: ");
			int rate = Integer.parseInt(input.readLine());
		
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
		
}
	

}
