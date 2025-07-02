package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

/**
 *
 * @author c2sha
 */
public class BoardingPass extends JFrame implements ActionListener {
    
    JTextField tfpnr;
    JLabel labeldate;
    Choice source, destination;
    JButton fetchbutton, flight, bookflight;
    JLabel labeldest, tfname, tfnationality, labelfname, labelfcode, tfsrc;    
    public BoardingPass(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //heading
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.RED);
        add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(380, 50, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.DARK_GRAY);
        add(subheading);
        
        
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setBounds(60, 100, 150, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);
        
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
        //fetchbutton
        fetchbutton = new JButton("Enter");
        fetchbutton.setBackground(Color.BLACK);
        fetchbutton.setForeground(Color.WHITE);
        fetchbutton.setBounds(380, 100, 150, 25);
        fetchbutton.addActionListener(this);
        add(fetchbutton);
        
        
        //name
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        
        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);
        
        //nationality
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        //Aadhar
        
        
        //address
        JLabel lblsrc = new JLabel("SOURCE");
        lblsrc.setBounds(60, 220, 150, 25);
        lblsrc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add (lblsrc);
        
        
        tfsrc = new JLabel();
        tfsrc.setBounds(220, 220, 150, 25);
        add (tfsrc);
        
        
        //gen der
        JLabel lbldest = new JLabel("DESTINATION");
        lbldest.setBounds(380, 220, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add (lbldest);
        
        
        labeldest = new JLabel();
        labeldest.setBounds(540, 220, 150, 25);
        
        add (labeldest);
        
        
        
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        
        labelfname= new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        add(labeldate);
        
        
        
        fetchbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("ENTER"), "press");

        fetchbutton.getActionMap().put("press", new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    fetchbutton.doClick(); // simulate button press
                }
            });
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);
        
        
        
        
        setSize(1000,450);
        setLocation(300, 150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == fetchbutton){
           
        String pnr = tfpnr.getText();
        
        try {
            
            Conn conn = new Conn();
            
            String query = "select * from reservation where PNR = '"+pnr+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
    
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfsrc.setText(rs.getString("src"));
                labeldest.setText(rs.getString("des"));
                labelfname.setText(rs.getString("flightname"));
                labelfcode.setText(rs.getString("flightcode"));
                labeldate.setText(rs.getString("ddate"));
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
            }
            
            
            
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
    
            
        }
        
        
    }
    public static void main(String[] args){
        
        new BoardingPass();
    }
    
}
