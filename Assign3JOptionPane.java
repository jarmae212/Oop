package sammer_baja;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Assign3JOptionPane {
	public static void main(String[] args) {
    	DecimalFormat d = new DecimalFormat("0.000");
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();
        
        Object[] message = {
            "First name: ", field1,
            "Middle initial: ", field2,
            "Last name: ", field3,
            "Monthly contribution: ", field4,
            "Interest rate: ", field5,
        };
        
        int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
        
        if (option == JOptionPane.OK_OPTION) {
            String firstName = field1.getText();
            String mid = field2.getText();
            String lastName = field3.getText();
            double contribution = Double.parseDouble(field4.getText());
            int rate = Integer.parseInt(field5.getText());

            float annualContribution = (float)contribution * 12;
        	double annualDividend = annualContribution * rate/100;
            
            char FirstInitials = firstName.charAt(0);
        	char MidInitials = mid.charAt(0);
        	char LastInitials = lastName.charAt(0);
            
            // Show the entered values in a message dialog
            String messageText = "Full name: " + firstName +" "+ mid +" "+lastName+"\n"+
            					"Initials: "+FirstInitials+MidInitials+LastInitials+"\n"+
                                 "Monthly contribution: " + contribution + "\n" +
                                 "Interest rate: " + rate+"\n"+
                                 "Annual Contribution: "+d.format(annualContribution)+"\n"+
                                 "Annual Divident: "+d.format(annualDividend);
            JOptionPane.showMessageDialog(null, messageText, "Entered Values", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("User canceled input.");
        }
    }
}
