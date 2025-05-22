//package ClientProject;
// testing
import java.util.*;

public class TestingPage {

	public static void main(String[] args) {
		Inventory mySystem=new Inventory();
		List<group> teams=new ArrayList<group>();
		group storage=new group(0);
		group group1=new group(1);
		teams.add(group1);
		group1.addMember("Ryan");
		group1.addMember("Conrad");
		group1.addMember("Suhanee");
		group1.addMember("Radhana");
		mySystem.addItem(new Electronic("Arduino",true,storage,0));
		mySystem.addItem(new Electronic("Arduino",false,storage,1));
		mySystem.addItem(new Electronic("Arduino",true,storage,2));
		mySystem.addItem(new Electronic("Arduino",true,storage,3));
		mySystem.addItem(new Electronic("Arduino",true,storage,4));
		mySystem.addItem(new Electronic("Raspberry Pi",true,group1,5));
		System.out.println(mySystem);
		mySystem.get(0).borrow(group1);
		mySystem.get(1).borrow(group1);
		mySystem.get(2).borrow(group1);
		System.out.println();
		System.out.println(mySystem);
		System.out.println(mySystem.locate(0));
		System.out.println(mySystem.statistics("Arduino"));
	}

}
