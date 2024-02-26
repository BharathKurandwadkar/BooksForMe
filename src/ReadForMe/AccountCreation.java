package ReadForMe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AccountCreation extends JFrame implements ActionListener, FocusListener {
    JLabel h1, error;
    JButton back, submit, clear;
    JTextField username, mob, email, pasw, con_pas, add;

    AccountCreation() {
        getContentPane().setBackground(new Color(250, 231, 201));
        setLayout(null);
        setVisible(true);
        setSize(1000, 550);
        setTitle("Creation of New Account");
        setLocation(230, 135);
        setResizable(false);

        h1 = new JLabel("Create a new account");
        h1.setFont(new Font("Arial Black", Font.BOLD, 25));
        h1.setBounds(350, 20, 350, 90);

        username = createTextFieldWithPlaceholder("Enter Username", 410, 110);
        mob = createTextFieldWithPlaceholder("Enter Mobile Number", 410, 160);
        email = createTextFieldWithPlaceholder("Enter email_id", 410, 210);
        pasw = createTextFieldWithPlaceholder("Enter password", 410, 260);
        con_pas = createTextFieldWithPlaceholder("Confirm your password", 410, 310);
        add = createTextFieldWithPlaceholder("Enter Your Address", 410, 360);

        error = new JLabel();
        error.setBounds(400, 390, 250, 40);
        error.setForeground(Color.red);

        submit = new JButton("Submit");
        submit.setBounds(370, 420, 120, 40);
        submit.setBackground(new Color(176, 146, 106));

        clear = new JButton("Clear");
        clear.setBounds(520, 420, 120, 40);
        clear.setBackground(new Color(176, 146, 106));

        back = new JButton("Back");
        back.setBounds(880, 470, 70, 20);
        back.setBackground(new Color(176, 146, 106));

        add(back);
        add(h1);
        add(username);
        add(mob);
        add(email);
        add(pasw);
        add(con_pas);
        add(add);
        add(submit);
        add(clear);
        add(error);

        back.addActionListener(this);
        submit.addActionListener(this);
        clear.addActionListener(this);

        // Add FocusListener to each text field
        username.addFocusListener(this);
        mob.addFocusListener(this);
        email.addFocusListener(this);
        pasw.addFocusListener(this);
        con_pas.addFocusListener(this);
        add.addFocusListener(this);
    }

    private JTextField createTextFieldWithPlaceholder(String placeholder, int x, int y) {
        JTextField textField = new JTextField(placeholder);
        textField.setBounds(x, y, 200, 30);
        textField.setBackground(new Color(225, 199, 143));
        textField.setName(placeholder);
        textField.setForeground(Color.gray); 
        return textField;
    }

    public static void main(String[] args) {
        new AccountCreation();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back){
			setVisible(false);
			new Login();
		}
		
		if (e.getSource() == submit) {
		    if (username.getText().isEmpty() || mob.getText().isEmpty() || email.getText().isEmpty()) {
		        error.setText("CAN'T BE EMPTY!");
		    } else {
		        if (pasw.getText().equals(con_pas.getText())) {
		            try {
		               
		                Class.forName("oracle.jdbc.driver.OracleDriver");
		                
		                
		                String URL = "jdbc:oracle:thin:@localhost:1521:XE";
		                String USER = "BOOKSFORME";
		                String PASS = "12345";
		                Connection con = DriverManager.getConnection(URL, USER, PASS);

		                
		                Statement st = con.createStatement();

		               
		                String insertQuery = "INSERT INTO account (name, mobile_no, email, pass, pass2,address) VALUES ('" +
		                        username.getText() + "', '" + mob.getText() + "', '" + email.getText() + "', '" +
		                        pasw.getText() + "', '" + con_pas.getText() + "','"+add.getText()+"')";
		                st.executeUpdate(insertQuery);

		                System.out.println("Data inserted into account table successfully");

		                
		                st.close();
		                con.close();

		               
		                setVisible(false);
		                new Login();
		            } catch (SQLException | ClassNotFoundException ex) {
		                System.out.println("Error: " + ex);
		            }
		        } else {
		            error.setText("PASSWORDS AREN'T MATCHING !");
		        }
		    }
		}
		
		if(e.getSource()==clear){
			username.setText("");
			mob.setText("");
			email.setText("");
			pasw.setText("");
			con_pas.setText("");
			add.setText("");
		}
		
	}

    @Override
    public void focusGained(FocusEvent e) {
        JTextField field = (JTextField) e.getSource();
        if (field.getText().equals(field.getName())) {
            field.setText("");
            field.setForeground(Color.black);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField field = (JTextField) e.getSource();
        if (field.getText().isEmpty()) {
            field.setText(field.getName());
            field.setForeground(Color.gray);
        }
    }
}
