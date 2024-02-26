package ReadForMe;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class printing extends JFrame implements ActionListener{
	JButton back;
	JPanel contentPane;
	JTextField bookTitle;
	JTextField language;
	JTextField noPages;
	JTextField qty;
	JTextField link;
	JComboBox<String> qualityComboBox ;
	JPanel panel;
	JLabel bill_cont;
	int count=0,sum=0,Bqty;
	String Bname,Bquality;
	String name,address,mobNo,email;
	printing(String name,String address,String mobNo,String email){
		 getContentPane().setBackground(new Color(250, 231, 201));
	        setLayout(null);
	        setVisible(true);
	        setSize(1000, 550);
	        setTitle("Printing");
	        setLocation(230,135);
	        setResizable(false);
	        this.name=name;
			this.address=address;
			this.email=email;
			this.mobNo=mobNo;
	        
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setBackground(new Color(250, 231, 201));
	        contentPane.setLayout(null);

	        back = new JButton("Back");
	        back.setBounds(880, 485, 70, 20);
	        back.setBackground(new Color(176, 146, 106));

	        String heading = "<html><pre> Fill The Details For Printing Your Own Book</pre></html>";
	        JLabel main_head = new JLabel(heading);
	        main_head.setForeground(new Color(150, 126, 118));
	        main_head.setFont(new Font("Arial Black", Font.BOLD, 32));
	        main_head.setBounds(40, 10, 865, 40);
	        contentPane.add(main_head);

	        JLabel book_title = new JLabel("Book Title");
	        book_title.setBounds(95, 71, 120, 25);
	        contentPane.add(book_title);

	        bookTitle = new JTextField();
	        bookTitle.setBounds(237, 71, 138, 25);
	        bookTitle.setBackground(new Color(222, 208, 182));
	        contentPane.add(bookTitle);
	        bookTitle.setColumns(10);
		
		JLabel lang = new JLabel("Language");
		lang.setBounds(95, 127, 120, 25);
		contentPane.add(lang);
		
		language = new JTextField();
		language.setBounds(237, 127, 138, 25);
		language.setBackground(new Color(222, 208, 182));
		contentPane.add(language);
		language.setColumns(10);
		
		JLabel No_p = new JLabel("No. of pages");
		No_p.setBounds(95, 181, 120, 25);
		contentPane.add(No_p);
		
		noPages = new JTextField();
		noPages.setBounds(237, 181, 138, 25);
		noPages.setBackground(new Color(222, 208, 182));
		contentPane.add(noPages);
		noPages.setColumns(10);
		
		JLabel qual = new JLabel("Quality");
		qual.setBounds(95, 241, 120, 25);
		contentPane.add(qual);
		
		qualityComboBox = new JComboBox<>();
		qualityComboBox.addItem("High Quality");
        qualityComboBox.addItem("Medium Quality");
        qualityComboBox.addItem("Low Quality");
		qualityComboBox.setBounds(237, 241, 138, 25);
		qualityComboBox.setBackground(new Color(222, 208, 182));
		contentPane.add(qualityComboBox);
	
		JLabel dlink = new JLabel("Link");
		dlink.setBounds(97, 295, 118, 22);
		contentPane.add(dlink);
		
		link = new JTextField();
		link.setBounds(237, 294, 138, 25);
		link.setBackground(new Color(222, 208, 182));
		contentPane.add(link);
		link.setColumns(10);
		
		JLabel quantity= new JLabel("Quantity");
		quantity.setBounds(95, 357, 120, 19);
		contentPane.add(quantity);
		
		
		ImageIcon plus_img=new ImageIcon(ClassLoader.getSystemResource("Images/plus.png"));
		JButton plus = new JButton(plus_img);
		plus.setBounds(261, 356, 25, 25);
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				qty.setText(count+"");			}
		});
		plus.setBackground(new Color(176,146,106));
		contentPane.add(plus);
		
		qty= new JTextField(count+"");
		qty.setBounds(294, 356, 37, 25);
		qty.setBackground(new Color(222, 208, 182));
		contentPane.add(qty);
		qty.setColumns(10);
		
		ImageIcon minus_img=new ImageIcon(ClassLoader.getSystemResource("Images/minus.png"));
		JButton minus = new JButton(minus_img);
		minus.setBounds(338, 356, 25, 25);
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count>0) {
					count--;
				}
				qty.setText(count+"");
			}
		});
		minus.setBackground(new Color(176,146,106));
		contentPane.add(minus);
		
		panel = new JPanel();
        panel.setBounds(613, 60, 346, 421);
        panel.setBackground(new Color(215, 192, 174));
        contentPane.add(panel);
        panel.setLayout(null);

        bill_cont = new JLabel("");
        bill_cont.setBounds(10, 59, 326, 317);
        panel.add(bill_cont);

        JButton submit = new JButton("Submit");
        submit.setBounds(143, 447, 85, 21);
        submit.setBackground(new Color(176, 146, 106));
        contentPane.add(submit);
		submit.addActionListener(new ActionListener() {
			
	
			@Override
			public void actionPerformed(ActionEvent e) {
				handleSubmission();
			}
			
		});
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(290, 447, 85, 21);
		cancel.setBackground(new Color(176,146,106));
		contentPane.add(cancel);
		cancel.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bookTitle.setText("");
				language.setText("");
				noPages.setText("");
				qty.setText("");
				link.setText("");
				
			}
			
		});
		
		
		
		String head_2="<html><pre>    Bill</pre></html>";
		JLabel bill_head= new JLabel(head_2);
		bill_head.setBounds(45, 10, 269, 26);
		bill_head.setFont(new Font("Arial Black",Font.BOLD,30));
		bill_head.setForeground(new Color(69, 69, 69));
		panel.add(bill_head);
		
		
		
		
		
		
		
		add(back);
		back.addActionListener(this);
	}
	
	void handleSubmission() {
		 bill_cont.setText("");
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	            String USER = "BOOKSFORME";
	            String PASS = "12345";
	            Connection con = DriverManager.getConnection(URL, USER, PASS);

	            Statement st = con.createStatement();

	            String insertQuery = "INSERT INTO newBook (booktitle, language, No_pages, quality, link,Quantity) VALUES ('" +
	                    bookTitle.getText() + "', '" + language.getText() + "', '" + noPages.getText() + "', '" +
	                    qualityComboBox.getSelectedItem() + "', '" + link.getText() + "','" + qty.getText() + "')";
	            st.executeUpdate(insertQuery);

	            System.out.println("Data inserted into newBook table successfully");

	            String selectQuery = "SELECT * FROM newBook WHERE bookTitle = '" + bookTitle.getText() + "'";
	            ResultSet rs = st.executeQuery(selectQuery);

	            if (rs.next()) {
	                System.out.println("Generating bill");
	                String bill = billGenerator(rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(6));
	                updateBillLabel(bill);

	                createBillTextFile(bill);
	               
	            }

	            st.close();
	            con.close();

	        }  catch (SQLException | ClassNotFoundException | IOException ex) {
	            System.out.println("Error: " + ex);
	        }
	    
	    }
	 
	void updateBillLabel(String text) {
	        bill_cont.setText("<html><pre>" + text + "</pre></html>");
	        bill_cont.revalidate();
	        bill_cont.repaint();
	        bill_cont.setBounds(10, 59, 326, 317);
	    }
	
	public static String billGenerator(String name, String no_pages, String qual, String qty) {
        int quality = 1;
        int sum;
        int qty1 = Integer.parseInt(qty);
        int noPages = Integer.parseInt(no_pages);
        if (qual.equals("High Quality")) {
            quality = 3;
        } else if (qual.equals("Medium Quality")) {
            quality = 2;
        } else if (qual.equals("Low Quality")) {
            quality = 1;
        }
        sum = noPages * quality * qty1;
        return "<html><pre>Book Title:" + name + " \n Number of Pages:" + no_pages + " \n Quality Selected :" +
        qual + " \n Quantity:" + qty1 + "\n Total Sum :<b>" + sum + "</b></pre></html>";

    }
	
	private void createBillTextFile(String bill) throws IOException {
        
        String fileName = "bill_" + System.currentTimeMillis() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            
            writer.write(bill);
        } catch (IOException e) {
            System.out.println("Error creating bill text file: " + e);
            throw e;
        }

        System.out.println("Bill text file created: " + fileName);
    }

	public static void main(String[] args) {
		
		new printing(null,null,null,null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			setVisible(false);
			new Home(name,address,mobNo,email);
		}
		
	}

}
