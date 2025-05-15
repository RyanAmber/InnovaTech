package ClientProject;

public class Electronic {
	private String type;
	private boolean IsWorking;
	private group groupUsing;
	private static int id;
	public int myID;
	public Electronic(String type,group g) {
		this.type=type;
		IsWorking=true;
		groupUsing=g;
		myID=id;
		id++;
	}
	public Electronic(String type, boolean working, group g) {
		this.type=type;
		IsWorking=working;
		groupUsing=g;
		myID=id;
		id++;
	}
	public String toString() {
		return (IsWorking?"Working":"Broken")+" "+type+" in group:"+groupUsing+" ID:"+myID;
	}
	public String getType() {
		return type;
	}
	public group getGroup() {
		return groupUsing;
	}
	public boolean getWorking() {
		return IsWorking;
	}
	public void setWorking(boolean working) {
		IsWorking=working;
	}
	public boolean borrow(group g) {
		if (IsWorking&&groupUsing.getTeamNum()==0) {
			groupUsing=g;
			return true;
		}
		return false;
	}
}
