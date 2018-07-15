import javax.swing.*;
import java.awt.event.*;
public class Alogin implements ActionListener{
	JFrame obj2=new JFrame();
JLabel l2,l3,l4;
JButton b3,b4;
JTextField t1;
JPasswordField p1;
Alogin()
{
l2=new JLabel("Admin Login Form");	
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
b4.setBounds(270,300,70,40);	
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
{String a1=t1.getText();
 String a2=p1.getText();
if(a1.equals("admin")&&a2.equals("admin123")){

new Adminsec();	
obj2.setVisible(false);			
}
}
if(s1.equals("Back")){new Library();obj2.setVisible(false);}
}

}