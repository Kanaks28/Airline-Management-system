
package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author c2sha
 */
public class AddCustomer extends JFrame implements ActionListener {
    
    JTextField tfname, tfnationality, tfaadhar, tfphone, tfaddress;
    JRadioButton rbmale, rbfemale, rbothers;
    
    public AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //heading
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        //name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 210, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 210, 25);
        add(tfname);
        
        //nationality
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 210, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 210, 25);
        add(tfnationality);
        
        //Aadhar
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60, 180, 210, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 210, 25);
        add(tfaadhar);
        
        //address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 210, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 210, 25);
        add(tfaddress);
        
        
        //gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 210, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        

        rbmale = new JRadioButton("Male");
        rbmale.setBackground(Color.WHITE);
        rbmale.setBounds(220, 280, 70, 25);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setBounds(300, 280, 70, 25);
        add(rbfemale);
        
        rbothers = new JRadioButton("Others");
        rbothers.setBackground(Color.WHITE);
        rbothers.setBounds(380, 280, 70, 25);
        add(rbothers);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        gendergroup.add(rbothers);
        
        //phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60, 330, 210, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 210, 25);
        add(tfphone);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 380, 210, 30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(510, 80, 280, 400);
        add(lblimage);
        
        
        
        save.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("ENTER"), "press");

        save.getActionMap().put("press", new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    save.doClick(); // simulate button press
                }
            });
        
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        } else if(rbfemale.isSelected()){
            gender = "Female";
        } else if(rbothers.isSelected()){
            gender = "Others";
        }
        
       
        try {
            
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"')";
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            
            setVisible(false);
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        
        new AddCustomer();
    }
    
}
