import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


public class Depstore extends JFrame {
JPanel pnlMain = new JPanel();

JLabel lblFirstName = new JLabel ("First Name: ");
JLabel lblLastName = new JLabel ("Last Name: ");
JLabel lblMobileNumber = new JLabel ("Mobile Number: ");

JButton btnSubmit = new JButton ("Submit");
JButton btnClearAll = new JButton ("ClearAll");

JTextField fldFirstName = new JTextField(16);
JTextField fldLastName = new JTextField(16);
JTextField fldMobileNumber = new JTextField(16);

JTextArea outputArea = new JTextArea (8, 25);

FlowLayout fl = new FlowLayout();
Font setFont = new Font ("",Font.BOLD, 14);

	public static void main (String[] args) {
		Depstore Departmentstore = new Depstore();


}
public Depstore() {
this.setSize(350,350);
this.setLocation(200,200);
this.setTitle("School IS");
this.setResizable(false);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

outputArea.setBackground(Color.LIGHT_GRAY);
outputArea.setEditable(false);
outputArea.setFont(setFont);

fldFirstName.setFont(setFont);
fldLastName.setFont(setFont);
fldMobileNumber.setFont(setFont);

pnlMain.add(lblFirstName);
pnlMain.add(fldFirstName);
pnlMain.add(lblLastName);
pnlMain.add(fldLastName);
pnlMain.add(lblMobileNumber);
pnlMain.add(fldMobileNumber);
pnlMain.add(outputArea);

btnSubmit.addActionListener(new actionButton1());
pnlMain.add(btnSubmit);
btnClearAll.addActionListener(new actionButton2());
pnlMain.add(btnClearAll);

this.add(pnlMain);
this.setVisible(true);

}
class actionButton1 implements ActionListener {
@Override
public void actionPerformed(ActionEvent a) {
String firstName = fldFirstName.getText();
String lastName = fldLastName.getText();
String MobileNumber = fldMobileNumber.getText();
outputArea.append("\nFirst Name:\n "+firstName+
"\n\nLast Name:\n " +lastName+ "\n\nMobile Number:\n "+ MobileNumber);

try{


	FileWriter fw = new FileWriter("Depstore.txt", true);
	PrintWriter pw = new PrintWriter(fw);

	pw.append(firstName + " " + lastName + " " + MobileNumber + " ");
	

//	pw.println(System.getProperty("line.seperator"));

	pw.close();
	JOptionPane.showMessageDialog(null,"Success");
	setVisible(false);

	new Depstore().setVisible(true);
}
catch(Exception e){
	JOptionPane.showMessageDialog(null,"Error");
}

}
}
class actionButton2 implements ActionListener {
@Override
public void actionPerformed(ActionEvent e){
fldFirstName.setText("");
fldLastName.setText("");
fldMobileNumber.setText("");
outputArea.setText("");
}
}
}

