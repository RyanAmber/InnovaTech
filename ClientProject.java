package ClientProject;

public class ClientProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventory mySystem=new Inventory();
		mySystem.addItem(new Electronic("Arduino",true,0));
		mySystem.addItem(new Electronic("Arduino",false,0));
		mySystem.addItem(new Electronic("Raspberry Pi",true,4));
		System.out.println(mySystem);
		mySystem.get(0).borrow(3);
		mySystem.get(1).borrow(3);
		mySystem.get(2).borrow(3);
		System.out.println();
		System.out.println(mySystem);
	}

}
