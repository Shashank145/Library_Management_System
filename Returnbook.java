import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Returnbook implements ActionListener{
JFrame obj6=new JFrame();
JLabel la,lb,lc;
JTextField ta,tb;
JButton ba,bb;
String p;
int q;
int a=0;
 Returnbook(){
la=new JLabel("Return Book");
lb=new JLabel("Book Callno:");
lc=new JLabel("Student Id:");


ta=new JTextField();
tb=new JTextField();


ba=new JButton("Return Book");
bb=new JButton("Back");
obj6.setSize(500,350);
obj6.setVisible(true);
obj6.setLayout(null);

la.setBounds(180,20,100,30);
lb.setBounds(30,90,100,30);
lc.setBounds(30,140,100,30);

ta.setBounds(180,90,180,30);
tb.setBounds(180,140,180,30);

ba.setBounds(200,200,110,35);
bb.setBounds(370,240,70,35);
obj6.add(la);
obj6.add(lb);
obj6.add(lc);

obj6.add(ta);
obj6.add(tb);

obj6.add(ba);
obj6.add(bb);
obj6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ba.addActionListener(this);
bb.addActionListener(this);
}

public void actionPerformed(ActionEvent e1)
{
String s=e1.getActionCommand();
if(s.equals("Return Book"))
{
	
		
try{
Class.forName("com.mysql.jdbc.Driver");
 System.out.println("driver found");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library"+"?verifyServerCertificate=false"+"&useSSL=true"+"&requireSSL=false","root","");
System.out.println("connection established");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select Call_No,Student_Id from issuebooks");
p=ta.getText();
q=Integer.parseInt(tb.getText());
System.out.println(q);
while(rs.next())
{
String x=rs.getString(1);
 int y=Integer.parseInt(rs.getString(2));
System.out.println(y);
if(p.equals(x) && q==y)
{
String delete="delete from issuebooks where Call_No=? and Student_Id=?";
PreparedStatement stmt=con.prepareStatement(delete);
 System.out.println("statement created successfully");
 
 stmt.setString(1,p);
 stmt.setInt(2,q);
 stmt.executeUpdate();
 
PreparedStatement prestmt=con.prepareStatement("update addbooks set Quantity=Quantity+1 where Call_No=?");
prestmt.setString(1,p);
prestmt.executeUpdate();

JOptionPane.showMessageDialog(obj6,"Book returned successfully!");
a=1;
}
}
if(a==0)
{
JOptionPane.showMessageDialog(obj6,"Sorry,unable to return book!");
}
con.close();
}catch(ClassNotFoundException e){System.out.println("driver not found");}

catch(SQLException e){System.out.println("connection not established");}
	
	
	
	
	
	
	
	
}

if(s.equals("Back"))
{new Thirdframe();obj6.setVisible(false);}

}
public static void main(String args[])
{
Returnbook objjj=new Returnbook();		
}

}