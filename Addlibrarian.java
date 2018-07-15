
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Addlibrarian implements ActionListener{
JFrame obj4=new JFrame();
JLabel la,lb,lc,ld,le,lf,lg;
JTextField ta,tb,tc,td,te,tf;
JButton ba,bb;

 Addlibrarian(){
la=new JLabel("Add Librarian");
lb=new JLabel("Name:");
lc=new JLabel("Password:");
ld=new JLabel("Email:");
le=new JLabel("Address:");
lf=new JLabel("city:");
lg=new JLabel("contact:");

ta=new JTextField();
tb=new JPasswordField();
tc=new JTextField();
td=new JTextField();
te=new JTextField();
tf=new JTextField();

ba=new JButton("Add Librarian");
bb=new JButton("Back");
obj4.setSize(500,600);
obj4.setVisible(true);
obj4.setLayout(null);

la.setBounds(180,20,100,30);
lb.setBounds(30,90,100,30);
lc.setBounds(30,140,100,30);
ld.setBounds(30,190,100,30);
le.setBounds(30,240,100,30);
lf.setBounds(30,290,100,30);
lg.setBounds(30,340,100,30);
ta.setBounds(180,90,180,30);
tb.setBounds(180,140,180,30);
tc.setBounds(180,190,180,30);
td.setBounds(180,240,180,30);
te.setBounds(180,290,180,30);
tf.setBounds(180,340,180,30);
ba.setBounds(200,380,110,35);
bb.setBounds(370,440,70,35);
obj4.add(la);
obj4.add(lb);
obj4.add(lc);
obj4.add(ld);
obj4.add(le);
obj4.add(lf);
obj4.add(lg);
obj4.add(ta);
obj4.add(tb);
obj4.add(tc);
obj4.add(td);
obj4.add(te);
obj4.add(tf);
obj4.add(ba);
obj4.add(bb);
obj4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ba.addActionListener(this);
bb.addActionListener(this);
}

public void actionPerformed(ActionEvent ee)
{
String s1=ee.getActionCommand();	
if(s1.equals("Add Librarian"))
{

try{
Class.forName("com.mysql.jdbc.Driver");
 System.out.println("driver found");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library"+"?verifyServerCertificate=false"+"&useSSL=true"+"&requireSSL=false","root","");
System.out.println("connection established");
String insert="insert into addlibrarian(Name,Password,Email,Address,City,Contact)values(?,?,?,?,?,?)";
PreparedStatement stmt=con.prepareStatement(insert);
 System.out.println("statement created successfully");
 
 stmt.setString(1,ta.getText());
 stmt.setString(2,tb.getText());
 stmt.setString(3,tc.getText());
 stmt.setString(4,td.getText());
 stmt.setString(5,te.getText());
 stmt.setInt(6,Integer.parseInt(tf.getText()));
 
 stmt.executeUpdate();
 
JOptionPane.showMessageDialog(obj4,"Librarian added successfully!");
con.close();
}catch(ClassNotFoundException e){System.out.println("driver not found");}

catch(SQLException e){System.out.println("connection not established");}

	
}
if(s1.equals("Back")){new Adminsec();obj4.setVisible(false);}	
	
}
public static void main(String args[])
{
new Addlibrarian();		
}

}