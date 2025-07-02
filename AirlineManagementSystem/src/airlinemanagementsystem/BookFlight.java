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
public class BookFlight extends JFrame implements ActionListener {
    
    JTextField tfaadhar;
    JDateChooser dcdate;
    Choice source, destination;
    JButton fetchbutton, flight, bookflight;
    JLabel labelgender, tfname, tfnationality, labelfname, labelfcode, tfaddress;    
    public BookFlight(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //heading
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(300, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(140, 80, 210, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(300, 80, 210, 25);
        add(tfaadhar);
        
        //fetchbutton
        fetchbutton = new JButton("Fetch");
        fetchbutton.setBackground(Color.BLACK);
        fetchbutton.setForeground(Color.WHITE);
        fetchbutton.setBounds(530, 80, 140, 25);
        fetchbutton.addActionListener(this);
        add(fetchbutton);
        
        
        //name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(140, 130, 210, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        
        tfname = new JLabel();
        tfname.setBounds(300, 130, 210, 25);
        add(tfname);
        
        //nationality
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(140, 180, 210, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        
        tfnationality = new JLabel();
        tfnationality.setBounds(300, 180, 210, 25);
        add(tfnationality);
        
        //Aadhar
        
        
        //address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(140, 230, 210, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        
        tfaddress = new JLabel();
        tfaddress.setBounds(300, 230, 210, 25);
        add(tfaddress);
        
        
        //gen der
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(140, 280, 210, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        
        labelgender = new JLabel("Gender");
        labelgender.setBounds(300, 280, 210, 25);
        
        add(labelgender);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(140, 330, 120, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(300, 330, 210, 25);
        
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(140, 380, 120, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        
        destination = new Choice();
        destination.setBounds(300, 380, 210, 25);
       
        add(destination);
        
        
        
        try{
            
            Conn c = new Conn();
            String queryS = "select distinct source from flight";
            
            
            ResultSet rs1 = c.s.executeQuery(queryS);
            
            
            while(rs1.next()){
                source.add(rs1.getString("source"));
                
            }
            
            String queryD = "select distinct destination from flight";
            ResultSet rs2 = c.s.executeQuery(queryD);
            while(rs2.next()){
                destination.add(rs2.getString("destination"));
            }
            
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        //phone
//        JLabel lblphone = new JLabel("Phone");
//        lblphone.setBounds(140, 330, 210, 25);
//        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblphone);
//        
        
//        tfphone = new JLabel();
//        tfphone.setBounds(300, 330, 210, 25);
//        add(tfphone);
//        
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(530, 380, 140, 25);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(140, 430, 210, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        
        labelfname= new JLabel();
        labelfname.setBounds(300, 430, 210, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(140, 480, 210, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        
        labelfcode = new JLabel();
        labelfcode.setBounds(300, 480, 210, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(140, 530, 210, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        
        dcdate = new JDateChooser();
        dcdate.setBounds(300, 530, 210, 25);
        add(dcdate);
        
        bookflight = new JButton("Book Flights");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(300, 600, 210, 30);
        bookflight.addActionListener(this);
        add(bookflight);
        
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(700, 150, 400, 410);
        add(lblimage);
        
        
        bookflight.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("ENTER"), "press");

        bookflight.getActionMap().put("press", new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    bookflight.doClick(); // simulate button press
                }
            });
        
        fetchbutton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("ENTER"), "press");

        fetchbutton.getActionMap().put("press", new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    fetchbutton.doClick(); // simulate button press
                }
            });
        
        flight.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("ENTER"), "press");

        flight.getActionMap().put("press", new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    flight.doClick(); // simulate button press
                }
            });
        
        
        setSize(1100,700);
        setLocation(275, 75);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == fetchbutton){
           
        String aadhar = tfaadhar.getText();
        
        try {
            
            Conn conn = new Conn();
            
            String query = "select * from passenger where aadhar = '"+aadhar+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
    
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaddress.setText(rs.getString("address"));
                labelgender.setText(rs.getString("gender"));
                
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
            }
            
            
            
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
    
            
        }
        if(ae.getSource() == flight){
           
        String src = source.getSelectedItem();
        String dst = destination.getSelectedItem();
        
        
        try {
            
            Conn conn = new Conn();
            
            String query = "select * from flight where source = '"+src+"'"+" and destination = '"+dst+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                
                labelfname.setText(rs.getString("f_name"));
                labelfcode.setText(rs.getString("f_code"));
    
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Flight through this route does not exist");
            }
            
            
            
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
    
            
        }
        
        else if(ae.getSource() == bookflight){
            
            Random random = new Random();
             
            String aadhar =tfaadhar.getText();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String src = source.getSelectedItem();
            String dst = destination.getSelectedItem();
    
            
            String name = tfname.getText();
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText();
            String flightcode = labelfcode.getText();
            
            try {
            
            Conn conn = new Conn();
            
            String query = "insert into reservation values ('PNR-" + random.nextInt(1000000) + "', 'TIC-" + random.nextInt(1000) + "', '" + aadhar + "', '" + name + "', '" + nationality + "', '" + flightname + "', '" + flightcode + "', '" + src + "', '" + dst + "', '" + ddate + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Ticket booked successfully");
            setVisible(false);
            
            
            
            
            
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
            
        }
        
        
    }
    public static void main(String[] args){
        
        new BookFlight();
    }
    
}
