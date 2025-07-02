package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


/**
 *
 * @author c2sha
 */
public class Home extends JFrame implements ActionListener{
    
   
    public Home(){
        
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        add(image);
        
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(550, 40, 1000, 40);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Tahima", Font.PLAIN, 36));
        image.add(heading);
        
        JMenuBar menubar = new JMenuBar();  
        setJMenuBar(menubar);
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        details.add(flightDetails);
        flightDetails.addActionListener(this);
        
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        details.add(customerDetails);
        customerDetails.addActionListener(this);
        
//        JMenuItem reservationDetails = new JMenuItem("Reservation Details");
//        details.add(reservationDetails);
//        reservationDetails.addActionListener(this);
        
        JMenuItem bookDetails = new JMenuItem("Book Flight");
        details.add(bookDetails);
        bookDetails.addActionListener(this);
        
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        details.add(journeyDetails);
        journeyDetails.addActionListener(this);
        
        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        details.add(ticketCancellation);
        ticketCancellation.addActionListener(this);
        
        JMenu ticket = new JMenu("Tickets");
        menubar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        ticket.add(boardingPass);
        boardingPass.addActionListener(this);
        
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setVisible(true);
        
        
        
        
    }
    //methodoverriding
    
    public void actionPerformed(ActionEvent ae){
        String text = ae.getActionCommand();
        
        if(text.equals("Add Customer Details")){
            new AddCustomer();
            
        } else if(text.equals("Flight Details")){
            new FlightInfo();
            
        } else if(text.equals("Book Flight")){
            new BookFlight();
        } else if(text.equals("Journey Details")){
            new JourneyDetails();
        } else if(text.equals("Cancel Ticket")){
            new Cancel();
        }
         else if(text.equals("Boarding Pass")){
            new BoardingPass();
        }
        
       
        
       
    }
    public static void main(String[] args){
       new Home();
       
        
        
    }
    
}