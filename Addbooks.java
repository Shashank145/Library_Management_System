
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Addbooks implements ActionListener{
JFrame obj4=new JFrame();

String p,q,r,x,y,z;
int w;
int a;
PreparedStatement p1;
JLabel la,lb,lc,ld,le,lf;
JTextField ta,tb,tc,td,te;
JButton ba,bb;

 Addbooks(){
la=new JLabel("Add Books");
lb=new JLabel("Call No:");
lc=new JLabel("Name:");
ld=new JLabel("Author");
le=new JLabel("Publisher");
lf=new JLabel("Quantity");

ta=new JTextField();
tb=new JTextField();
tc=new JTextField();
td=new JTextField();
te=new JTextField();

ba=new JButton("Add Books");
bb=new JButton("Back");
obj4.setSize(500,500);
obj4.setVisible(true);
obj4.setLayout(null);

la.setBounds(180,20,100,30);
lb.setBounds(30,90,100,30);
lc.setBounds(30,140,100,30);
ld.setBounds(30,190,100,30);
le.setBounds(30,240,100,30);
lf.setBounds(30,290,100,30);
ta.setBounds(180,90,180,30);
tb.setBounds(180,140,180,30);
tc.setBounds(180,190,180,30);
td.setBounds(180,240,180,30);
te.setBounds(180,290,180,30);
ba.setBounds(200,330,110,35);
bb.setBounds(370,380,70,35);
obj4.add(la);
obj4.add(lb);
obj4.add(lc);
obj4.add(ld);
obj4.add(le);
obj4.add(lf);
obj4.add(ta);
obj4.add(tb);
obj4.add(tc);
obj4.add(td);
obj4.add(te);
obj4.add(ba);
obj4.add(bb);
obj4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ba.addActionListener(this);
bb.addActionListener(this);
}

public void actionPerformed(ActionEvent ee)
{
String s1=ee.getActionCommand();	
if(s1.equals("Add Books"))
{

try{
Class.forName("com.mysql.jdbc.Driver");
 System.out.println("driver found");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library"+"?verifyServerCertificate=false"+"&useSSL=true"+"&requireSSL=false","root","");
System.out.println("connection established");
Statement ps=con.createStatement();
ResultSet rs=ps.executeQuery("select Name,Author,Publisher from addbooks");
System.out.println("query run");
p=tb.getText();
q=tc.getText();
r=td.getText();
w=Integer.parseInt(te.getText());
System.out.println(p+" "+q+" "+r+" "+w);

while(rs.next())
{
x=rs.getString(1) ;
y=rs.getString(2);
z=rs.getString(3);

if(p.equals(x) && q.equals(y) && r.equals(z))
{
PreparedStatement pstmt=con.prepareStatement("update addbooks set Quantity=Quantity+? where Name=?");
pstmt.setInt(1,w);
pstmt.setString(2,x);
pstmt.executeUpdate();
a=1;

}

}
if(a==0)
{
String insert="insert into Addbooks(Call_No,Name,Author,Publisher,Quantity)values(?,?,?,?,?)";
PreparedStatement stmt=con.prepareStatement(insert);
 System.out.println("statement created successfully");
 
 stmt.setString(1,ta.getText());
 stmt.setString(2,tb.getText());
 stmt.setString(3,tc.getText());
 stmt.setString(4,td.getText());
 stmt.setInt(5,Integer.parseInt(te.getText()));
 
 stmt.executeUpdate();
}
JOptionPane.showMessageDialog(obj4,"Books added successfully!");
con.close();
}catch(ClassNotFoundException e){System.out.println("driver not found");}

catch(SQLException e){System.out.println("connection not established");}

	
}
if(s1.equals("Back"))
{
new Thirdframe();
obj4.setVisible(false);
}
	
}
public static void main(String args[])
{
new Addbooks();		
}

}