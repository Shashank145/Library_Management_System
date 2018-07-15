import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Secondframe implements ActionListener{
	JFrame obj2=new JFrame();
JLabel l2,l3,l4;
JButton b3,b4;
JTextField t1;
JPasswordField p1;
Secondframe()
{
l2=new JLabel("Librarian Login Form");	
l3=new JLabel("Enter Name:");
l4=new JLabel("Enter Password:");
b3=new JButton("Login");
b4=new JButton("Back");	
t1=new JTextField();	
p1=new JPasswordField();
obj2.setSize(400,400);
obj2.setVisible(true);
obj2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
obj2.setLayout(null);
l2.setBounds(120,30,200,50);	
l3.setBounds(20,120,110,30);	
l4.setBounds(20,190,110,30);	
b3.setBounds(130,260,130,40);	
t1.setBounds(150,120,150,30);	
p1.setBounds(150,190,150,30);
b4.setBounds(280,300,70,40);	
obj2.add(l2);
obj2.add(l3);
obj2.add(l4);
obj2.add(b3);
obj2.add(b4);
obj2.add(t1);
obj2.add(p1);
b3.addActionListener(this);
b4.addActionListener(this);
}

public void actionPerformed(ActionEvent e1){
String s1=e1.getActionCommand();
if(s1.equals("Login"))
{
try{
Class.forName("com.mysql.jdbc.Driver");
System.out.println("driver found");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library"+"?verifyServerCertificate=false"+"&useSSL=true"+"&requireSSL=false","root","");
Statement ps=con.createStatement();

ResultSet rs=ps.executeQuery("select Name,Password from addlibrarian"); 
while(rs.next()){
	String p=t1.getText();
	String q=p1.getText();
if((p.equals(rs.getString(1))) && (q.equals(rs.getString(2))))
{new Thirdframe();
obj2.setVisible(false);}
}
con.close();
}catch(ClassNotFoundException e){System.out.println("driver not found");}

catch(SQLException e){System.out.println("connection not established");}


}
if(s1.equals("Back"))
{new Library();obj2.setVisible(false);}

}

}