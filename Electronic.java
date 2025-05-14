package ClientProject;

public class Electronic {
	private String type;
	private boolean IsWorking;
	private int groupUsing;
	private static int id;
	public int myID;
	public Electronic(String type) {
		this.type=type;
		IsWorking=true;
		groupUsing=0;
		myID=id;
		id++;
	}
	public Electronic(String type, boolean working, int group) {
		this.type=type;
		IsWorking=working;
		groupUsing=group;
		myID=id;
		id++;
	}
	public String toString() {
		return (IsWorking?"Working":"Broken")+" "+type+" in group:"+groupUsing+" ID:"+myID;
	}
	public String getType() {
		return type;
	}
	public int getGroup() {
		return groupUsing;
	}
	public boolean getWorking() {
		return IsWorking;
	}
	public void setWorking(boolean working) {
		IsWorking=working;
	}
	public boolean borrow(int group) {
		if (IsWorking&&groupUsing==0) {
			groupUsing=group;
			return true;
		}
		return false;
	}
}
