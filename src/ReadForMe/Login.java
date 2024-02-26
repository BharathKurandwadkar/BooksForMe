package ReadForMe;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener, FocusListener  {

    JLabel heading1, heading2, image, n_user, error;
    JTextField username, password;
    JButton submit, cancel, new_acc;
    String name, pass;

    Login() {
        getContentPane().setBackground(new Color(250, 231, 201));
        setLayout(null);
        setVisible(true);
        setSize(1000, 550);
        setTitle("Login Tab");
        setLocation(230, 135);
        setResizable(false);

        heading1 = new JLabel("Books For Me");
        heading1.setFont(new Font("Arial Black", Font.BOLD, 32));
        heading1.setBounds(550, 10, 300, 90);

        heading2 = new JLabel("Sign In");
        heading2.setFont(new Font("Arial", Font.BOLD, 26));
        heading2.setBounds(620, 100, 160, 80);
        
        username = createTextFieldWithPlaceholder("Enter Username", 570, 180);
        password = createTextFieldWithPlaceholder("Enter Password", 570, 230);
//        username = new JTextField("Enter Username");
//        username.setBounds(570, 180, 220, 40);
//        username.setBackground(new Color(225, 199, 143));
//
//        password = new JTextField("Enter password");
//        password.setBounds(570, 230, 220, 40);
//        password.setBackground(new Color(225, 199, 143));

        submit = new JButton("Submit");
        submit.setBounds(570, 280, 120, 40);
        submit.setBackground(new Color(176, 146, 106));

        cancel = new JButton("Clear");
        cancel.setBounds(720, 280, 120, 40);
        cancel.setBackground(new Color(176, 146, 106));

        error = new JLabel();
        error.setBounds(580, 340, 300, 40);
        error.setForeground(Color.RED);

        n_user = new JLabel("New User ? ");
        n_user.setBounds(570, 400, 80, 40);

        new_acc = new JButton("Create Account");
        new_acc.setBounds(640, 410, 140, 20);
        new_acc.setBackground(new Color(250, 231, 201));

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("Images/main_img.jpg"));
        image = new JLabel(img1);
        image.setBounds(0, 0, 413, 550);

        add(heading1);
        add(heading2);
        add(username);
        add(password);
        add(submit);
        add(cancel);
        add(n_user);
        add(new_acc);
        add(image);
        add(error);

        username.addFocusListener(this);
        password.addFocusListener(this);

        submit.addActionListener(this);
        cancel.addActionListener(this);
        new_acc.addActionListener(this);
    }

    private JTextField createTextFieldWithPlaceholder(String placeholder, int x, int y) {
        JTextField textField = new JTextField(placeholder);
        textField.setBounds(x, y, 200, 40);
        textField.setBackground(new Color(225, 199, 143));
        textField.setName(placeholder);
        textField.setForeground(Color.gray); 
        return textField;
    }
    public static void main(String[] args) {
        new Login();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submit) {
			name=username.getText();
			pass=password.getText();
			 try {
				 
			        
			        Class.forName("oracle.jdbc.driver.OracleDriver");

			       
			        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
			        String USER = "booksforme";
			        String PASS = "12345";
			        Connection con = DriverManager.getConnection(URL, USER, PASS);

			        
			        Statement st = con.createStatement();

			      
			        String selectQuery ="SELECT * FROM account WHERE name = '" + name + "' AND pass = '" + pass + "'";
			        ResultSet rs = st.executeQuery(selectQuery);

			        if (rs.next()) {
			            System.out.println("Login successful!");
			            setVisible(false);
						new Home(rs.getString(1),rs.getString(6),rs.getString(2),rs.getString(3));
			            
			        } else {
			            System.out.println("Invalid login credentials!");
			            error.setText("USERNAME AND PASSWORD IS INCORRECT");
			            
			        }

			    
			        rs.close();
			        st.close();
			        con.close();
			    } catch (SQLException | ClassNotFoundException ex) {
			        System.out.println("Error: " + ex);
			    }
			
			
		}
		else if(e.getSource()==cancel) {
			username.setText("");
			password.setText("");
			
		}
		else if(e.getSource()==new_acc) {
			setVisible(false);
			new AccountCreation();
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
