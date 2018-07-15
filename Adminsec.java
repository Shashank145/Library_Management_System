import javax.swing.*;
import java.awt.event.*;
public class Adminsec implements ActionListener{
	JFrame obj3=new JFrame();
JButton b4,b5,b6,b7;
Adminsec()
{
b4=new JButton("Add Librarian");
b5=new JButton("View Librarian");
b6=new JButton("Delete Librarian");
b7=new JButton("Logout");

obj3.setSize(400,500);
obj3.setVisible(true);
obj3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
obj3.setLayout(null);
b4.setBounds(130,60,130,40);
b5.setBounds(130,130,130,40);
b6.setBounds(130,200,130,40);
b7.setBounds(130,270,130,40);
obj3.add(b4);
obj3.add(b5);
obj3.add(b6);
obj3.add(b7);
b4.addActionListener(this);
b6.addActionListener(this);
b5.addActionListener(this);
b7.addActionListener(this);
}
public void actionPerformed(ActionEvent e2){
 String s3=e2.getActionCommand();
if(s3.equals("Add Librarian")){
new Addlibrarian();
obj3.setVisible(false);}
if(s3.equals("View Librarian")){
new Viewlibrarian();
obj3.setVisible(false);}
if(s3.equals("Delete Librarian")){
new Deletel();
obj3.setVisible(false);}
if(s3.equals("Logout")){
new Library();
obj3.setVisible(false);}
}}