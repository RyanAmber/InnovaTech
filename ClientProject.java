package ClientProject;

import java.util.*;

public class ClientProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventory mySystem=new Inventory();
		group storage=new group(0);
		group group1=new group(1);
		group1.addMember("Ryan");
		group1.addMember("Conrad");
		group1.addMember("Suhanee");
		group1.addMember("Radhana");
		mySystem.addItem(new Electronic("Arduino",true,storage));
		mySystem.addItem(new Electronic("Arduino",false,storage));
		mySystem.addItem(new Electronic("Raspberry Pi",true,group1));
		System.out.println(mySystem);
		mySystem.get(0).borrow(group1);
		mySystem.get(1).borrow(group1);
		mySystem.get(2).borrow(group1);
		System.out.println();
		System.out.println(mySystem);
		System.out.println(mySystem.locate(0));
	}

}
