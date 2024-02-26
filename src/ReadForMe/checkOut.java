package ReadForMe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

	public class checkOut extends JFrame implements ActionListener {
	    private JPanel mainPanel, paymentPanel, purchasePanel;
	    private JLabel totalAmountLabel, paymentMethodLabel, headingLabel;
	    private JButton purchaseButton, backButton;
	    private JRadioButton cashRadioButton, upiRadioButton;
	    private static double totalAmount = 0;  // Changed to instance variable
	    private static String userName;
	    private String numString;
	    private JLabel imageLabel;
	    public checkOut(double price, String name) {
	        userName = name;

	        getContentPane().setBackground(new Color(250, 231, 201));

	        headingLabel = new JLabel("<html><pre> Hello " + userName + "! Your Total Bill is Here...</pre></html>");
	        headingLabel.setForeground(new Color(150, 126, 118));
	        headingLabel.setFont(new Font("Arial Black", Font.BOLD, 28));
	        headingLabel.setHorizontalAlignment(JLabel.CENTER);
	        headingLabel.setBorder(new EmptyBorder(20, 0, 20, 0));

	        totalAmountLabel = new JLabel("Total Amount: $" + price);
	        totalAmountLabel.setHorizontalAlignment(JLabel.CENTER);
	        totalAmountLabel.setFont(new Font("Arial", Font.BOLD, 18));

	        setLayout(new BorderLayout());
	        setSize(900, 600);
	        setTitle("Checkout");
	        setLocation(320,110);


	        initializeMainPanel();
	        initializePaymentPanel();
	        initializePurchasePanel();
	        
	        
	       
	        mainPanel.add(headingLabel, BorderLayout.NORTH);
	        mainPanel.add(Box.createVerticalStrut(20));  // Add vertical spacing
	        mainPanel.add(totalAmountLabel, BorderLayout.CENTER);
	        mainPanel.add(paymentPanel, BorderLayout.SOUTH);
	        mainPanel.add(purchasePanel, BorderLayout.SOUTH);
	        mainPanel.add(backButton, BorderLayout.SOUTH);
	        
	        add(mainPanel);

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
	        
	        cashRadioButton.addActionListener(this);
	        upiRadioButton.addActionListener(this);
	        purchaseButton.addActionListener(this);
	        backButton.addActionListener(this);
	        
	        upiRadioButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JTextField upiField = new JTextField();
	                JPanel panel = new JPanel(new GridLayout(0, 1));
	                panel.add(new JLabel("Enter Your UPI ID:"));
	                panel.add(upiField);

	                Object[] options = { "OK", "Cancel" };

	                int result = JOptionPane.showOptionDialog(null, panel, "UPI ID Entry",
	                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

	                if (result == JOptionPane.YES_OPTION) {
	                    numString = upiField.getText();
	                    if (numString == null || numString.trim().isEmpty()) {
	                        JOptionPane.showMessageDialog(checkOut.this,
	                                "<html>Error!!!<br>Please Enter Your UPI ID </html>", "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	                }
	            }

	        });

	   	 

	        purchaseButton.addActionListener(new ActionListener() {
	            @Override
	            
	            public void actionPerformed(ActionEvent e) {
	            	if(cashRadioButton.isSelected())
	            	{
	            		JOptionPane.showMessageDialog(checkOut.this,"<html>Dear " + userName + ",<br>Thank you for your purchase!<br></html>",
			                    "Purchase Confirmation", JOptionPane.INFORMATION_MESSAGE);
	            		setVisible(false);
		                new Successful();
	            	}
	            	else if (numString == null || numString.trim().isEmpty())
	            	{
	            		JOptionPane.showMessageDialog(checkOut.this, "<html>Error!!!<br>Please Enter Your UPI ID </html>",
		                        "Error", JOptionPane.ERROR_MESSAGE);
	            	}
	            	else
	            	{
	                JOptionPane.showMessageDialog(checkOut.this,"<html>Dear " + userName + ",<br>Thank you for your purchase!<br></html>",
		                    "Purchase Confirmation", JOptionPane.INFORMATION_MESSAGE);
	                setVisible(false);
	                new Successful();
	            	}
	            }
	        });

	    }

	    private void initializeMainPanel() {
	        mainPanel = new JPanel();
	        mainPanel.setBackground(new Color(250, 231, 201));
	        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
	    }

	    private void initializePaymentPanel() {
	        paymentPanel = new JPanel();
	        paymentPanel.setBackground(new Color(250, 231, 201));
	        paymentPanel.setLayout(new GridLayout(10, 1, 10, 10));

	        paymentMethodLabel = new JLabel("Select Payment Method:");
	        paymentMethodLabel.setFont(new Font("Arial", Font.BOLD, 14));

	        cashRadioButton = new JRadioButton("Cash On Delivery");
	        cashRadioButton.setBackground(new Color(176, 146, 106));
	        cashRadioButton.setForeground(Color.white);

	        upiRadioButton = new JRadioButton("UPI");
	        upiRadioButton.setBackground(new Color(176, 146, 106));
	        upiRadioButton.setForeground(Color.white);

	        ButtonGroup paymentGroup = new ButtonGroup();
	        paymentGroup.add(cashRadioButton);
	        paymentGroup.add(upiRadioButton);

	        paymentPanel.add(paymentMethodLabel);
	        paymentPanel.add(cashRadioButton);
	        paymentPanel.add(upiRadioButton);
	    }

	    private void initializePurchasePanel() {
	        purchasePanel = new JPanel();
	        purchasePanel.setBackground(new Color(250, 231, 201));

	        purchaseButton = new JButton("Purchase");
	        purchaseButton.setBackground(new Color(176, 146, 106));
	        purchaseButton.setForeground(Color.white);

	        backButton = new JButton("Back");
	        backButton.setBackground(new Color(176, 146, 106));
	        backButton.setForeground(Color.white);

	        purchasePanel.add(purchaseButton);
	        purchasePanel.setVisible(false);
	    }

	   
	       
	   

	    public void actionPerformed(ActionEvent e) {
	        if (cashRadioButton.isSelected() || upiRadioButton.isSelected()) {
	            purchasePanel.setVisible(true);
	        }

	        if (e.getSource() == backButton) {
	            setVisible(false);
	            new Home(userName, null,null,null);
	        }
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new checkOut(totalAmount,userName);
	}

}