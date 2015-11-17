package Server;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Teacher {
   public static void main(String[] args) {
      
      JButton okButton = new JButton("Run Simulation for the Next Day");
      ButtonHandler listener = new ButtonHandler();
      okButton.addActionListener(listener);
      
      JLabel title = new JLabel();
      title.setText("Here is a list of connected users and their data status:");
     
      JLabel day = new JLabel();
      day.setText("This is day 1.");
      
      String playerList[] ={"User A", "User B", "User C", "User D", "User E"};
      
      JList userList = new JList(playerList);
      
      String dataStatus[] ={"OK", "-", "OK", "OK", "-"};
      
      JList data = new JList(dataStatus);
      
      
      JPanel content = new JPanel();
      content.setLayout(new BorderLayout());
      content.add(okButton, BorderLayout.SOUTH);
      content.add(title, BorderLayout.NORTH);
      content.add(day, BorderLayout.EAST);
      content.add(data, BorderLayout.CENTER);
      content.add(userList, BorderLayout.WEST);

      JFrame window = new JFrame("Coffee Shop Simulation Management Console");
      window.setContentPane(content);
      window.setSize(500,500);
      window.setLocation(100,100);
      window.setVisible(true);
      
      window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

   }
   

   
   private static class ButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
//do-nothing
      }
   }
   
}