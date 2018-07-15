import javax.swing.*;
import java.awt.event.*;
public class Library implements ActionListener{
JFrame f1=new JFrame();	
	JLabel l1;
JButton b1,b2;



Library(){
l1=new JLabel("Library Management");
b1=new JButton("Admin Login");
b2=new JButton("Librarian Login");
f1.setSize(400,400);
f1.setVisible(true);
f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f1.setLayout(null);
l1.setBounds(130,30,200,60);
b1.setBounds(120,100,150,50);
b2.setBounds(120,200,150,50);
f1.add(l1);
f1.add(b1);
f1.add(b2);
b2.addActionListener(this);
b1.addActionListener(this);
} 



public void actionPerformed(ActionEvent e){
String s=e.getActionCommand();
if(s.equals("Librarian Login"))
{	
Secondframe obj=new Secondframe();				
f1.setVisible(false);	
}
if(s.equals("Admin Login"))
{	
new Alogin();				
f1.setVisible(false);	
}

}

public static void main(String args[]){
Library f=new Library();

}}
