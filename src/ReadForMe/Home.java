package ReadForMe;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Home extends JFrame implements ActionListener{
	
	JButton cartbut,myac,close1,close2,buy,printing,checkOut,clear;
	JMenuBar m1;
	JLayeredPane layer;
	
	String name,address,mobNo,email;
	JPanel p1,mypro,mycart,p3;
	JLabel icon1,l6,sumTotal,head,company;
	double totalprice=0;
	
	Home(String name,String address,String mobNo,String email){
		getContentPane().setBackground(new Color(250,231,201));
		setLayout(null);
		setVisible(true);
		setSize(1000,550);
		setTitle("Home");
		setLocation(230,135);
		setResizable(false);
		this.name=name;
		this.address=address;
		this.email=email;
		this.mobNo=mobNo;
		
		m1=new JMenuBar();
		m1.setForeground(Color.white);
		m1.setBackground(new Color(112,98,51));
		
		printing =new JButton("Printing");
		printing.setForeground(Color.white);
		printing.setBackground(new Color(112,98,51));
		
		String comp="<html><pre>                                                "
				+ "                    &#169; 2023-2024, BooksForMe, Inc. By Bharath and Sandesh</pre><html>";
		company=new JLabel(comp);
		company.setForeground(Color.white);
		
		
		m1.add(printing);
		m1.add(company);
		setJMenuBar(m1);
		
		p1=new JPanel();
		p1.setBounds(0,0,1000,50);
		p1.setBackground(new Color(176,146,106));
		p1.setLayout(null);
		
		ImageIcon ic=new ImageIcon();
		ic=resize("C:\\Users\\bhara\\Desktop\\Project_X\\ReadForMe\\src\\Images\\logo1.jpg",140,50);
		icon1=new JLabel(ic);
		icon1.setBounds(0,0,140,50);
		
		head=new JLabel("Books your heart longs for.");
		head.setBounds(190, 5, 470, 40);
		head.setForeground(Color.white);
		head.setFont(new Font("Rage Italic",Font.BOLD,40));
		head.setBackground(new Color(250,231,201));
		
		
		
		myac=new JButton("My Account");
		myac.setBounds(694, 3, 107, 42);
		myac.setBackground(new Color(176,146,106));
		myac.setForeground(Color.white);
		
		mypro=new JPanel();
		mypro.setLayout(null);
		mypro.setBounds(552,77,424,260);
		mypro.setBackground(new Color(225, 199, 143));
		JLabel userNameLabel = new JLabel("UserName: "+name);
        userNameLabel.setBounds(10, 20, 300, 25);
        mypro.add(userNameLabel);

        JLabel addressLabel = new JLabel("Address: "+address);
        addressLabel.setBounds(10, 60, 410, 25);
        mypro.add(addressLabel);

        JLabel emailLabel = new JLabel("EmailId: "+email);
        emailLabel.setBounds(10, 100, 400, 25);
        mypro.add(emailLabel);

        JLabel mobileNumberLabel = new JLabel("MobileNumber: "+mobNo);
        mobileNumberLabel.setBounds(10, 140, 300, 25);
        mypro.add(mobileNumberLabel);

		JButton log_out=new JButton("Log out");
		log_out.setBounds(160,230,100,27);
		log_out.setBackground(new Color(176,146,106));
		log_out.setForeground(Color.white);
		mypro.add(log_out);
		log_out.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);
			}
			
		});
		
	    
		ImageIcon icon2=new ImageIcon();	
		icon2=resize("C:\\Users\\bhara\\Desktop\\Project_X\\ReadForMe\\src\\Images\\wrong.png",21,21);
		close1=new JButton("",icon2);
		close1.setBounds(403, 0, 21, 21);
		mypro.add(close1);
		
		
		mypro.setVisible(false);
		
		
		mycart=new JPanel();
		mycart.setLayout(null);
		mycart.setBounds(552,77,424,357);
		mycart.setBackground(new Color(225, 199, 143));
		
		
		close2=new JButton("",icon2);
		close2.setBounds(403, 0, 21, 21);
		mycart.add(close2);
		mycart.setVisible(false);
		p3=new JPanel();
		p3.setBounds(0,27,424,300);
		l6=new JLabel("Your Cart is Empty!!");
		
		
		
		p3.add(l6);
		p3.setBackground(new Color(225, 199, 143));
		buy=new JButton("Buy now");
		
		buy.setBackground(new Color(176,146,106));
		buy.setForeground(Color.white);
		p3.add(buy);
		
		cartbut=new JButton("My Cart");
		cartbut.setBounds(845, 3, 107, 42);
		cartbut.setBackground(new Color(176,146,106));
		cartbut.setForeground(Color.white);
		
		sumTotal=new JLabel("");
		sumTotal.setBounds(224,320,100,40);
		sumTotal.setForeground(Color.BLUE);
		
		
		
		checkOut=new JButton("CheckOut");
		checkOut.setBackground(new Color(176,146,106));
		checkOut.setForeground(Color.white);
		checkOut.setBounds(324,330,100,25);
		checkOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				new checkOut(totalprice,name);
			}
			
		});	
		clear=new JButton("Clear");
		clear.setBackground(new Color(176,146,106));
		clear.setForeground(Color.white);
		clear.setBounds(20,330,100,25);
		
		
		
		mycart.add(p3);
		p1.add(icon1);p1.add(head);p1.add(myac);add(cartbut);
		add(p1);add(mypro);add(mycart);
		
		
		
	
		int numberOfBooks = 200;
        Icon[] bookImages = createBookImages(numberOfBooks);
        JPanel bookPanelsContainer = createBookPanelsContainer(bookImages);
        pack();
       
        setVisible(true);
	JScrollPane scrollPane=new JScrollPane(bookPanelsContainer);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setBounds(0, 70, 992, 411);
	getContentPane().add(scrollPane);
		setSize(1000,550);
		
		myac.addActionListener(this);
		cartbut.addActionListener(this);
		close1.addActionListener(this);
		close2.addActionListener(this);
		buy.addActionListener(this);
		printing.addActionListener(this);
		layer = getLayeredPane();
		layer.add(mycart, JLayeredPane.POPUP_LAYER);
		layer.add(mypro, JLayeredPane.POPUP_LAYER);
		
	}
	
	private Icon[] createBookImages(int numberOfBooks) {
       
        Icon[] bookImages = new ImageIcon[numberOfBooks];
        for (int i = 1; i <= numberOfBooks; i++) {
        	
            bookImages[i - 1] = resize("C:\\Users\\bhara\\Desktop\\Project_X\\ReadForMe\\src\\bookImg\\k"+i+".png",130,100);
        }
        return bookImages;
    }

	 private JPanel createBookPanelsContainer(Icon[] bookImages) {
	        JPanel container = new JPanel();
	        container.setLayout(new GridLayout(0, 6, 20, 20));
	        container.setBackground(new Color(250,231,201));
	        //Book Titles
	        String name[]={
	                "Malegalalli Madhumagalu", "Mookajjiya Kanasugalu", "Parva", "Kanooru Heggadati",
	                "Gruhabhanga", "Bettada Jeeva", "Avarana", "Chidambara Rahasya", "Mussange Kathaprasanga",
	                "Edakallu Guddadamele", "Sandhyaraga", "Nanna Biography", "Hasuru Honnu","Varadakshine", "Malenadina Chitragalu",
	                "Benda Kalu on Toast", "Sammilana", "Chikaveera Rajendra", "Tejo Tungabhadra", "Kannadigara Karmakathe",
	                "Nimma Suptaprajna Manassina Shakti", "Dinakkondu Kathe Part2", "World's Greatest Leaders",
	                "Deep Work", "Thinking, Fast and Slow", "Jugari Cross", "Nanna Hesaru Gulabi", "The Kid Came From Space",
	                "Kannada Sahitya Sanjeevini", "Samarasave Jeevana", "The Serpent's Revenge", "RSS",
	                "Hindus in Hindu Rashtra", "When the Wind God Feels Sick and Other Tales", "The Richest Man in Babylon",
	                "Norwegian Wood", "An Uncommon Love", "How to Use Your Healing Power", "You Can", "Believe in Yourself",
	                "How to Day Trade for a Living", "21 Days of Effective Communication", "1984", "Sapiens",
	                "Dopamine Detox", "Psychology: A Graphic Guide", "Verity", "Before the Coffee Gets Cold", "Wise and Otherwise",
	                "All in One: English Core", "Killer of the Flower Moon", "Maybe You Should Talk to Someone", "Say Nothing",
	                "American Carnage", "Radium Girls", "Born a Crime", "Howard Stern Comes Again", "The Indigo Story",
	                "How to Be an Antiracist", "The Fifth Risk", "Permanent Record", "Dare to Lead", "Not My Father's Son",
	                "Fear", "The Ghosts of Eden Park", "Ambedkar: A Life", "The World Montefiore", "Come Let's Run",
	                "The Last Heroes", "Modi: Shaping a Global Order in Flux", "As Good as My World", "Wings of Fire",
	                "Science Sample Papers", "Dark Psychology Secrets & Manipulation", "I'm Stuck in Your Kindle!", "3 Metamorphosis",
	                "Horror Stories", "Four Stars of Destiny", "Money Making Skills", "Indian Polity",
	                "Working Effectively with Legacy Code", "The Clean Coder", "Code Complete", "The Pragmatic Programmer",
	                "Soft Skills", "Domain-Driven Design", "Design Patterns", "Clean Code", "The Dev OOPs Handbook",
	                "Artificial Intelligence", "The Blue Zone Kitchen", "LifeSpan", "The Whole Body Micro Biome",
	                "The Telomere Effect", "How Not To Die", "Do It Today", "The Complete Sherlock Holmes", "Unnatural Causes",
	                "The Art of Saying No", "Coloring Books: For Kids", "The Power of a Positive Attitude",
	                "Personality Development", "Len-Den", "Bahurani", "Devi Chaudhrani", "Chanakya Charitram",
	                "Vishvaguru Vivekanand", "Gautam Buddha", "Yogi Paramahamsa", "Bhakti Ke Bhakt Ramakrishna Paramahamsa",
	                "Svasthya Trikona", "100 Baggers", "The Art of Laziness", "Think and Grow Rich", "Twelfth Fail",
	                "The Silent Patient", "Power", "Tuesday with Morrie", "Man's Searching for Meaning", "Breakout Trading",
	                "CashBack", "Grandma's Bag of Stories", "All Religions are Not the Same", "200+ Activities: For Kids",
	                "The Law of Attraction", "Chokher Bali", "Jeevanke Adbhut Rahasya", "Jeevan Jeeneki Kala", "Jeevan Kya Hai",
	                "Mrutyu", "Karma", "Apke Avchetan Manki Shakti", "Art of War", "Ek Yuva Ladkiki Diary", "Pride and Prejudice",
	                "Kitne Ghazi Aye Kitne Ghazi Gaye", "RAW Secret Agents", "Cyber Encounters", "Bahawalpur Ka Shatir Premi",
	                "The Hidden Hindu", "Ashwathama", "Satyayoddha Kalki", "Kashi - Kaale Mandir Ka Rahasya", "Harappa", "Mastaan",
	                "Anandmath", "Devi Chaudhurani", "Badi Didi", "Bahurati", "Len-Den", "Same as Ever",
	                "A Beginner's Guide to Stock Market", "UPSC Civil Services", "How to Talk to Anyone", "Shloka and Mantras",
	                "Python Programming", "The 5am Club", "The Courage to Be Disliked", "Girl Alone", "Sherlock Holmes",
	                "Guptagodana", "Narendra", "Gora", "P.G.T. English Literature", "TGT/PGT 2022", "Postcolonial Literature",
	                "World Literature", "British Literature", "Neetar for Competitive Examinations", "UP TGT English",
	                "Energize Your Mind", "33 Days Challenge", "Breaking the Mould", "One Indian Girl", "Price Action Trading",
	                "Master Your Thinking", "The Hidden Hindu", "Current Affairs 2024", "Think and Grow Rich",
	                "The Magic of the Lost Temple", "Dark Psychology and Manipulation", "UGC 2023", "Aranya Rakshaka",
	                "Shaikshanika Manovijnana", "Computer Literacy Test", "Samanya Kannada", "GK Tricks", "Computer",
	                "Itihasa", "Sainika Diksoochi", "Kannada Vyakarana Tantragalu", "Computer", "Shaikshanika Manovijnana",
	                "Jeevan Ke Mahan Satya", "The Prophet", "Budha Aadmi Aur Samudra", "Ek Din Zindagi Badal Jayegi",
	                "How to Enjoy Your Life and Your Job", "Yaar Papa", "Nirmala"
	            };
	         
	         
	    		   
//	    	String author[]=new String[200];
	        String[] authors = {
	                "Kuvempu", "Dr. K. Shivaram Karanth", "S.L. Bhyrappa", "Kuvempu", "S.L. Bhyrappa",
	                "Dr. K. Shivaram Karanth", "S.L. Bhyrappa", "K.P. Poornachandra Tejaswi", "P. Lankesh",
	                "Bharatisuta", "A.N. Krishnaraya", "Beechi", "B.G.L. Swami","Vasudhendra", "Kuvempu", "Girish Karnad",
	                "Saisute", "Shtinivasa", "Vasudhendra", "Galaganatha", "Joseph Murphy", "Dr. Nagalakshmi K.P.",
	                "Wonder House Books", "Cal Newport", "Daniel Kahneman", "K.P. Poornachandra Tejaswi",
	                "Sagar Kolanvkar", "Ross Welford", "Dr. Sivasharanappa Motakahalli", "V.K. Gokak", "Sudha Murty",
	                "Devanuru Mahadeva", "Anand Ranganathan", "ChandraShekhar Kambar", "George S. Clason", "Murakami",
	                "Sudha Murty", "Joseph Murphy", "George Matthew Adams", "Joseph Murphy", "Andrew Aziz",
	                "Jan Tuhovsky", "George Orwell", "Yuval Noah Harari", "Thibaut Meurisse", "Nicel C. Benson",
	                "Colleen Hoover", "Toshikazu Kawaguchi", "Sudha Murty", "Arihant", "David Grann", "Lori Gottlieb",
	                "Patrick Radden Keefe", "Tim Alberta", "Kate Moore", "Trevor Noah", "Howard Stern", "Shelley Vishwajeet",
	                "Ibram X. Kendi", "Michael Lewis", "Edward Snowden", "Brene Brown", "Alan Cumming", "Bob Woodward",
	                "Karen Abbott", "Shashi Tharoor", "Simon Sebag", "Ma. Subramanian", "P. Sainath", "S. Jaishankar",
	                "K.M. Chandrasekhar", "A.P.J. Abdul Kalam", "Educart", "Amy Brown", "Wally", "Franz Kafka",
	                "Scare Street", "General Manoj Mukund Naravane", "Warren Buffett", "M. Laxmikanth", "Michael C. Feathers",
	                "Robert C. Martin Series", "Steve McConnell", "David Thomas", "John Z. Sonmez", "Martin Fowler",
	                "Grady Booch", "Robert C. Martin", "John Wills", "Luca Massaron", "Dan Buettner", "David A. Sinclair",
	                "Jessica M. Finlay", "Elissa Epel", "Michael Greger", "Darius Foroux", "Arthur Conan Doyle",
	                "Dr. Richard Shepherd", "Damon Zahariades", "Wonder House Books", "Roger Fritz", "Dr. D.P. Sabarwal",
	                "Sharatchandra Chattopadhyaya", "Rabindranath Tagore", "Bankimchandra Chatterjee", "M.I. Rajasvi",
	                "M.I. Rajasvi", "Wonder House Book", "Yoganand", "Sarashri", "Sangraha", "Chistopher Mayer",
	                "Library Mindset", "Napoleon Hills", "Anurag Pathak", "Alex Michaelides", "Greene", "Mitch Albom",
	                "Viktor E. Frankl", "Indrazith Shantharaj", "Duccan James", "Sudha Murty", "Sanjay Dixit",
	                "Wonder House Books", "Laura Carter", "Rabindranath Tagore", "Gopal Das", "Swami Anand Satyarthi",
	                "Osho", "Sadguru", "Sadguru", "Dr. Joseph Murphy", "Sun taju", "Any Fraink", "Jane Austen",
	                "K.J.S. Dhillon", "Harsha Sharma", "Ashok Kumar", "Rahul Pandita", "Akshath Gupta", "M.I. Rajaswi",
	                "Kevin Missal", "Vineet Bajpai", "Vineet Bajpai", "Vineet Bajpai", "Bankimchandra Chatterjee",
	                "Bankimchandra Chatterjee", "Sharatchandra Chattopadhyaya", "Rabindranath Tagore",
	                "Sharatchandra Chattopadhyaya", "Morgan Housel", "Matthew R. Kratter", "Disha Publications",
	                "Leillowndes", "Wonder House Books", "Ramsey Hamilton", "Robin Sharma", "Ichiro Kishimi", "Blake Pierce",
	                "Arthur Conan Doyle", "Devakinandan Khatri", "Devakinandan Khatri", "Rabindranath Tagore", "Dr. Ramesh",
	                "Wonder House Books", "Pramod K. Nayar", "Dr. Prem Shankar Pandey", "Neeraj Publications", "Sudhir K",
	                "Yogesh Kumar", "Gaur Gopal Das", "99%Swaha Publications", "Rohit Lamba", "Chetan Bhagat", "Sunil Gurjar",
	                "Thibaut Meurisse", "Akshat Gupta", "Arihant", "Napoleon Hill", "Sudha Murty", "Margaret Morrison",
	                "K V S Madaan", "Spardha Unnadi", "Dr. H.V. Vamadevappa", "Vidya Chandrakumar", "Lakshmi Abhiram",
	                "Y.M. Mirji", "Chiguru","Chiguru", "A.R. Hegganadoddi", "Dr. R. Lokesh", "Dr. Gururaj M", "Dr. H.V. Vamadevappa",
	                "DR. JOSEPH MURPHY", "Kahlil Gibran", "Ernest Hemingway", "Saranya Umakanthan", "Del Karnegi",
	                "Divya Prakash Dubey", "Premchand"
	            };
	        
	        
	        double price[]={300,450,500,350,200,150,400,200,100,250,100,150,80,200,250,100,300,180,350,100,80,80,150,200,200,170,
	        		155,99,129,575,139,99,159,229,399,149,249,119,99,149,150,219,199,149,249,199,110,150,250,499,399,229,119,99,150,
	        		99,250,200,100,299,200,150,299,250,399,490,450,350,499,449,349,499,299,289,199,149,149,449,249,349,399,449,499,
	        		449,249,249,499,499,399,549,149,399,350,300,400,350,400,999,400,250,459,549,499,559,449,400,499,149,649,399,349,
	        		249,229,399,349,499,220,199,229,249,249,449,499,200,249,499,349,400,339,549,499,399,249,399,299,449,399,249,399,
	        		349,499,599,449,299,249,399,349,249,399,159,199,249,299,159,149,499,299,249,200,699,199,149,499,349,249,199,249,
	        		149,299,299,349,249,349,299,249,275,345,149,599,245,450,645,99,149,199,149,99,125,299,449,99,125,149,249,299,199,
	        		349,299,245,350};
	        for (int i = 0; i < bookImages.length; i++) {

	        	JPanel bookPanel = createBookPanel(i + 1, bookImages[i],name[i],authors[i],price[i]);
	            container.add(bookPanel);
	        }

	        return container;
	    }
	 
	 private JPanel createBookPanel(int bookId, Icon imageIcon,String name,String author,double price) {
	        JPanel bookPanel = new JPanel();
	        bookPanel.setLayout(new BorderLayout());
	        bookPanel.setPreferredSize(new Dimension(130, 125));
	        bookPanel.setBackground(Color.black);
	        
	        JLabel imageLabel = new JLabel(imageIcon);
	       
	        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        
	        JButton viewButton = new JButton();
	        for( int i=0 ; i<200 ; i++) {
	        	
	        	viewButton.setText(name);
	        }
	        viewButton.setBackground(new Color(176,146,106));
	        viewButton.setForeground(Color.white);

	        viewButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                showDetailsDialog(bookId,name,author,price);
	            }
	        });

	        bookPanel.add(imageLabel, BorderLayout.CENTER);
	        bookPanel.add(viewButton, BorderLayout.SOUTH);

	       
	        bookPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	        return bookPanel;
	    }
	 
	private void showDetailsDialog(int bookId,String name,String author,double price) {
        
        JPanel detailsPanel = new JPanel(new BorderLayout());
       
        String multiLineText = "<html>Book Name:"+name+"<br><br>Author:"+author+"<br><br>Price:"+price+"<br><br></html>";
        JLabel detailsLabel = new JLabel(multiLineText+""+ bookId);
        detailsPanel.add(detailsLabel, BorderLayout.NORTH);

        JButton buyNowButton = new JButton("Add To Cart");
        buyNowButton.setOpaque(false);
       
        buyNowButton.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(Home.this,name + " Will Be Added To Cart ", "Purchase Confirmation", JOptionPane.INFORMATION_MESSAGE);
                purchaseBook(bookId,name,author,price);
            }
        });
        mycart.setOpaque(true);
        p3.setOpaque(true);
        detailsPanel.add(buyNowButton, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(this, detailsPanel, "Book Details", JOptionPane.PLAIN_MESSAGE);
    }
	
	private void purchaseBook(int bookId,String name,String author,double price) {
	   
	    String pur="<html><pre>"+name+" book added to cart  <br></pre></html>";
	   
	    String totalPrice="Total:"+totalPrice(price);
	    sumTotal.setText(totalPrice+"");
	    p3.revalidate();
	    p3.repaint(); 
	    
	    JLabel purchasedLabel = new JLabel(pur);
	   
	    
	    
	    mycart.add(clear);
	    clear.addActionListener(this);
	    mycart.add(checkOut);
	    mycart.add(sumTotal);
	    p3.add(purchasedLabel);
	    
	    p3.remove(l6);p3.remove(buy);
	    
	}
	
	public  Double totalPrice(double price) {
		
		totalprice=totalprice+price;
		return totalprice;
	}

	 public static ImageIcon resize(String str, int width, int height) {
		 ImageIcon ic=new ImageIcon(str);
	        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	        Graphics2D g2d = (Graphics2D) bi.createGraphics();
	        g2d.addRenderingHints(//  ww  w  . jav  a2 s. c o m
	                new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(((ImageIcon) ic).getImage(), 0, 0, width, height, null);
	        g2d.dispose();
	        return new ImageIcon(bi);
	    }

	public static void main(String[] args) {
		
		new Home(null,null,null,null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==myac)
		{
			mycart.setVisible(false);
			mypro.setVisible(true);
		}
		if(e.getSource()==close1) {
			mypro.setVisible(false);
		}
		
		
		if(e.getSource()==cartbut)
		{
			mypro.setVisible(false);
			mycart.setVisible(true);
		}
		if(e.getSource()==close2) {
			mycart.setVisible(false);
		}
		if(e.getSource()==buy) {
			mycart.setVisible(false);
		}
		
		if(e.getSource()==printing) {
			new printing(name,address,mobNo,email);
			setVisible(false);
		}
		
		 if (e.getSource() == clear) {
		        clearCart();
		    }
		
	}

	private void clearCart() {
	    p3.removeAll();
	    mycart.remove(checkOut);
	    mycart.remove(sumTotal);
	    mycart.remove(clear);
	    p3.add(l6); 
	    p3.add(buy);
	    p3.revalidate(); 
	    p3.repaint();    
	    sumTotal.setText("");
	    totalprice = 0;   
	}

}