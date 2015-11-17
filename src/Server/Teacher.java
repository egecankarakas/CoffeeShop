package Server;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Teacher {
   public static void main(String[] args) {
      
      JButton okButton = new JButton("Run");
      ButtonHandler listener = new ButtonHandler();
      okButton.addActionListener(listener);
      
      JLabel title = new JLabel();
      title.setText("Coffee Shop Simulation Management Console");
      
      JList userList = new JList();
      
      JPanel content = new JPanel();
      content.setLayout(new BorderLayout());
      content.add(okButton, BorderLayout.SOUTH);
      content.add(title, BorderLayout.NORTH);
      content.add(userList, BorderLayout.CENTER);

      JFrame window = new JFrame("Coffee Shop Simulation Management Console");
      window.setContentPane(content);
      window.setSize(500,500);
      window.setLocation(100,100);
      window.setVisible(true);

   }
   

   
   private static class ButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
//do-nothing
      }
   }
   
}