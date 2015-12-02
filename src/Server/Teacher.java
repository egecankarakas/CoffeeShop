package Server;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class Teacher {
	ArrayList<Shop> shops;
	DefaultListModel playerList;
	ArrayList<String> dataStatus;
	HashMap<String,String> playerData;
	JList userJList;
	JList dataJList;
	public static boolean readyCheck;
	
	public static void main(String[] args) {

		JButton okButton = new JButton("Run Simulation for the Next Day");
		ButtonHandler listener = new ButtonHandler();
		okButton.addActionListener(listener);

		JLabel title = new JLabel();
		title.setText("Here is a list of connected users and their data status:");

		JLabel day = new JLabel();
		day.setText("This is day 1.");
		
		DefaultListModel dlm = new DefaultListModel();
		dlm.addElement("User A");
		dlm.addElement("User B");
		String playerList[] ={"User A", "User B", "User C", "User D", "User E"};

		JList userList = new JList(dlm);

		String dataStatus[] ={"OK", "-", "OK", "OK", "-"};

		JList data = new JList(dataStatus);

		dlm.addElement("User C");
		
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

	public Teacher(){
		JButton okButton = new JButton("Run Simulation for the Next Day");
		ButtonHandler listener = new ButtonHandler();
		okButton.addActionListener(listener);

		JLabel title = new JLabel();
		title.setText("Here is a list of connected users and their data status:");

		JLabel day = new JLabel();
		day.setText("This is day 1.");

		//String playerList[] ={"User A", "User B", "User C", "User D", "User E"};

		//this.shops = new ArrayList<Shop>();


		//String dataStatus[] ={"OK", "-", "OK", "OK", "-"};

		//this.dataJList = new JList(dataStatus);
		
		this.playerList = new DefaultListModel();
		playerList.addElement("User A");
		playerList.addElement("User B");
		playerList.addElement("User C");
		playerList.addElement("User D");
		playerList.addElement("User E");
		this.userJList = new JList(playerList);

		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.add(okButton, BorderLayout.SOUTH);
		content.add(title, BorderLayout.NORTH);
		content.add(day, BorderLayout.EAST);
		//content.add(dataJList, BorderLayout.CENTER);
		content.add(userJList, BorderLayout.WEST);

		JFrame window = new JFrame("Coffee Shop Simulation Management Console");
		window.setContentPane(content);
		window.setSize(500,500);
		window.setLocation(100,100);
		window.setVisible(true);

		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	

	public static class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Engine.actionApproved();
			Engine.readyCheck=true;
			Teacher.readyCheck=true;
		}
		
	}

}