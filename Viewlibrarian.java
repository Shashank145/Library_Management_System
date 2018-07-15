import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Viewlibrarian implements ActionListener{
JFrame f;
int p=0;
JButton b1;
JTable jt;
Viewlibrarian(){
f=new JFrame();
b1=new JButton("Back");

b1.setBounds(300,250,70,40);
f.add(b1);



try{	
Class.forName("com.mysql.jdbc.Driver");
System.out.println("driver found");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library"+"?verifyServerCertificate=false"+"&useSSL=true"+"&requireSSL=false","root","");
PreparedStatement ps=con.prepareStatement("select * from addlibrarian");
ResultSet rs=ps.executeQuery(); 
ResultSetMetaData rsmd=rs.getMetaData();


int count=rsmd.getColumnCount();
System.out.println(count);
int i,j;
String column[]=new String[count];
for(i=0;i<count;i++)
{
p++;
column[i]=rsmd.getColumnName(p);
}

String row[][]=new String[12][count];
int l=0;

while(rs.next())
{
int k=1;
for(j=0;j<count;j++)
{
row[l][j]=rs.getString(k);
k++;
}
jt=new JTable(row,column);
jt.setBounds(30,40,300,400);          
JScrollPane sp=new JScrollPane(jt);    
f.add(sp);          

l++;
}
f.setSize(420,400);    
f.setVisible(true);    
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
con.close();
}catch(ClassNotFoundException e){System.out.println("driver not found");}

catch(SQLException e){System.out.println("connection not established");}

b1.addActionListener(this);
 
}
public void actionPerformed(ActionEvent ee)
{
String s1=ee.getActionCommand();
if(s1.equals("Back"))
{
new Adminsec();
f.setVisible(false);
}
}

public static void main(String args[]){
	new Viewlibrarian();
	
}
}