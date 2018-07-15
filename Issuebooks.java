import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Issuebooks implements ActionListener{
JFrame obj5=new JFrame();
JLabel la,lb,lc,ld,le;
JTextField ta,tb,tc,td;
JButton ba,bb;
String p,x;
int y,a;

 Issuebooks(){
la=new JLabel("Issue Book");
lb=new JLabel("Book Callno:");
lc=new JLabel("Student Id:");
ld=new JLabel("Student Name:");
le=new JLabel("Student Contact:");

ta=new JTextField();
tb=new JTextField();
tc=new JTextField();
td=new JTextField();

ba=new JButton("Issue Books");
bb=new JButton("Back");
obj5.setSize(500,500);
obj5.setVisible(true);
obj5.setLayout(null);

la.setBounds(180,20,100,30);
lb.setBounds(30,90,100,30);
lc.setBounds(30,140,100,30);
ld.setBounds(30,190,100,30);
le.setBounds(30,240,100,30);
ta.setBounds(180,90,180,30);
tb.setBounds(180,140,180,30);
tc.setBounds(180,190,180,30);
td.setBounds(180,240,180,30);
ba.setBounds(200,330,110,35);
bb.setBounds(370,380,70,35);
obj5.add(la);
obj5.add(lb);
obj5.add(lc);
obj5.add(ld);
obj5.add(le);
obj5.add(ta);
obj5.add(tb);
obj5.add(tc);
obj5.add(td);
obj5.add(ba);
obj5.add(bb);
obj5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ba.addActionListener(this);
bb.addActionListener(this);
}


public void actionPerformed(ActionEvent ee)
{
String s1=ee.getActionCommand();	
if(s1.equals("Issue Books"))
{

try{
Class.forName("com.mysql.jdbc.Driver");
 System.out.println("driver found");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library"+"?verifyServerCertificate=false"+"&useSSL=true"+"&requireSSL=false","root","");
System.out.println("connection established");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select Call_No,Quantity from addbooks");
p=ta.getText();
while(rs.next())
{
x=rs.getString(1);
y=Integer.parseInt(rs.getString(2));
if(p.equals(x) && y>=1)
{
String insert="insert into issuebooks(Call_No,Student_Id,Student_Name,Student_Contact)values(?,?,?,?)";
PreparedStatement stmt=con.prepareStatement(insert);
 System.out.println("statement created successfully");
 
 stmt.setString(1,ta.getText());
 stmt.setInt(2,Integer.parseInt(tb.getText()));
 stmt.setString(3,tc.getText());
 stmt.setInt(4,Integer.parseInt(td.getText()));
 stmt.executeUpdate();

PreparedStatement prestmt=con.prepareStatement("update addbooks set Quantity=Quantity-1 where Call_No=?");
prestmt.setString(1,ta.getText());
prestmt.executeUpdate();
 
JOptionPane.showMessageDialog(obj5,"Book issued successfully!");
a=1;
}

}
if(a==0)
{
JOptionPane.showMessageDialog(obj5,"Book is not available!");
}
con.close();
}catch(ClassNotFoundException e){System.out.println("driver not found");}

catch(SQLException e){System.out.println("connection not established");}

	
}
if(s1.equals("Back")){new Thirdframe();obj5.setVisible(false);}	
	
}




public static void main(String args[])
{
Issuebooks objjj=new Issuebooks();		
}

}