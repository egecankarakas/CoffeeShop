package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JList;


public class Engine {
	static volatile ArrayList<Shop> shops = new ArrayList<Shop>();
	Teacher teacher;
	public static boolean readyCheck = false;
	public Engine(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public void updatePlayerList (Shop shop) {
		teacher.playerList.addElement(shop.id);
		shops.add(shop);
		shop.day++;
		System.out.println("waiting for ready check from the teacher");
		while(!Engine.readyCheck||!Teacher.readyCheck){
			try {
				System.out.println("waiting for ready check from the teacher");		
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Teacher approved");
		//teacher.userJList = new JList(teacher.playerList.toArray());
	}	
	public void updateDataList() {
		
	}
}
