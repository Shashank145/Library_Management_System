import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Deletel implements ActionListener{
JFrame f;
JLabel l1;
JTextField t1;
JButton b1,b2;
Deletel(){
f=new JFrame();
l1=new JLabel("Enter Name:");
t1=new JTextField();
b1=new JButton("Delete");
b2=new JButton("Back");
f.setSize(400,300);
f.setVisible(true);
f.setLayout(null);
l1.setBounds(30,60,120,30);
t1.setBounds(170,60,120,30);	
b1.setBounds(150,120,70,30);
b2.setBounds(200,200,70,30);
f.add(l1);
f.add(t1);
f.add(b1);
f.add(b2);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent e1){
String s=e1.getActionCommand();	
if(s.equals("Delete"))	
{
	
try{
Class.forName("com.mysql.jdbc.Driver");
 System.out.println("driver found");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library"+"?verifyServerCertificate=false"+"&useSSL=true"+"&requireSSL=false","root","");
System.out.println("connection established");
String delete="delete from addlibrarian where name=?";
PreparedStatement stmt=con.prepareStatement(delete);
 System.out.println("statement created successfully");
 
 stmt.setString(1,t1.getText());
 
 stmt.executeUpdate();
 
JOptionPane.showMessageDialog(f,"Librarian deleted successfully!");
con.close();
}catch(ClassNotFoundException e){System.out.println("driver not found");}

catch(SQLException e){System.out.println("connection not established");}


}	
if(s.equals("Back")){	
	new Adminsec();
         f.setVisible(false);
}
}
public static void main(String args[])
{
new Deletel();	
	
}	
}