
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


/**
 *
 * @author c2sha
 */
public class Login extends JFrame implements ActionListener{
    
    JButton bsubmit, breset, bclose;
    JTextField tfusername;
    JPasswordField tfpassword;
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        //username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 20, 100, 20);
        add(lblusername);
        
        //inputbox
        tfusername=new JTextField();
        tfusername.setBounds(120,20,220,20);
        add(tfusername);
        
        //password
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20,60,100,20);
        add(lblpassword);
        
        //passwordinputbox
        tfpassword=new JPasswordField();
        tfpassword.setBounds(120,60,220,20);
        add(tfpassword);
        
        //buttons
        //reset
        breset=new JButton("Reset");
        breset.setBounds(40,120,100,20);
        breset.addActionListener(this);
        add(breset);
        
        
        //login
        bsubmit=new JButton("Submit");
        bsubmit.setBounds(200,120,100,20);
        bsubmit.addActionListener(this);
        add(bsubmit);
        
        //close
        bclose=new JButton("Close");
        bclose.setBounds(120,160,100,20);
        bclose.addActionListener(this);
        add(bclose);
        
        setSize(400, 250);
        setLocation(600, 250);
        setVisible(true);
        
        
        bsubmit.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("ENTER"), "press");

        bsubmit.getActionMap().put("press", new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    bsubmit.doClick(); // simulate button press
                }
            });
        
    }
    //methodoverriding
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == bsubmit){
            String username=tfusername.getText();
            String password=tfpassword.getText();
            
            try{
                Conn c=new Conn();
                
                String query ="select * from login where username = '"+username+"' and password = '"+password+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    new Home();
                    setVisible(false);
                    
                } else{
                    JOptionPane.showMessageDialog(null , "Invalid Username or Password");
                }
            } catch (Exception e){
                
            }
            
            
        }else if(ae.getSource() == breset){
            tfusername.setText("");
            tfpassword.setText("");
            
            
        }else if(ae.getSource() == bclose){
            setVisible(false);
            
        }
        
    }
    public static void main(String[] args){
       new Login();
       
        
        
    }
    
}
