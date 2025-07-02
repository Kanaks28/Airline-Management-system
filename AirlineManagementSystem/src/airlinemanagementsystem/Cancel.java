package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Cancel extends JFrame implements ActionListener{
    JLabel tfpnr, tfname, tfcancellation, labelfcode, tfcode, ddate, name, labeldate, cancellationNumber;
    JButton showdetails, cancel;
    JTextField  pnr;
    Cancel(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(300,40,300,30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        tfpnr = new JLabel("PNR Number");
        tfpnr.setBounds(60, 120, 150, 25);
        tfpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfpnr);
        
        pnr = new JTextField();
        pnr.setBounds(220, 120, 210, 25);
        pnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(pnr);
        
        
        showdetails = new JButton("Show Details");
        showdetails.setBounds(460, 120, 150, 25);
        showdetails.setBackground(Color.BLACK);
        showdetails.setForeground(Color.WHITE);
        showdetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(showdetails);
        showdetails.addActionListener(this);
        
        
        tfname = new JLabel("Name");
        tfname.setBounds(60, 180, 150, 25);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfname);
        
        name = new JLabel();
        name.setBounds(220, 180, 210, 25);
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name);
        
        
        tfcancellation = new JLabel("Cancellation No");
        tfcancellation.setBounds(60, 240, 150, 25);
        tfcancellation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfcancellation);
        
        Random random = new Random();
        
        
        
        cancellationNumber = new JLabel(""+random.nextInt(10000));
        cancellationNumber.setBounds(220, 240, 210, 25);
        cancellationNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(cancellationNumber);
        
        
        tfcode = new JLabel("Flight Code");
        tfcode.setBounds(60, 300, 150, 25);
        tfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 300, 210, 25);
        labelfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelfcode);
        
        ddate = new JLabel("Date");
        ddate.setBounds(60, 360, 150, 25);
        ddate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(ddate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 360, 210, 25);
        labeldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labeldate);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(300, 420, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(cancel);
        cancel.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(500, 150, 400, 410);
        add(lblimage);
        
        
        cancel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("ENTER"), "press");

        cancel.getActionMap().put("press", new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    cancel.doClick(); // simulate button press
                }
            });
        
        showdetails.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("ENTER"), "press");

        showdetails.getActionMap().put("press", new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    showdetails.doClick(); // simulate button press
                }
            });
        
        
        
        
        
        
        
                
        setSize(900, 600);
        setLocation(350, 120);
        setVisible(true);
                
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == showdetails){
            String pnr1 = pnr.getText();
        
        try {
            
            Conn conn = new Conn();
            
            String query = "select * from reservation where PNR = '"+pnr1+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
    
                name.setText(rs.getString("name"));
                labelfcode.setText(rs.getString("flightcode"));
                labeldate.setText(rs.getString("ddate"));
                
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct PNR");
            }
            
            
            
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
    
            
        }
        
        if(ae.getSource() == cancel){
            String pnr1 = pnr.getText();
            String name1 = name.getText();
            String cancelno = cancellationNumber.getText();
            String code = labelfcode.getText();
            String date = labeldate.getText();
            
           
        
        try {
            
            Conn conn = new Conn();
            
            String query = "insert into cancel values ('"+pnr1+"','"+name1+"','"+cancelno+"','"+code+"','"+date+"')";
            conn.s.executeUpdate(query);
            
            String query_delete = "DELETE FROM reservation WHERE PNR = '" + pnr1 + "'";
            conn.s.executeUpdate(query_delete);
            
            JOptionPane.showMessageDialog(null, "Ticket cancelled successfully");
            setVisible(false);
            
            
            
            
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
    
            
        }
        }
        
    
    public static void main(String[] args){
        new Cancel();
    }
}
