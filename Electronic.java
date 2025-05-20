//package ClientProject;

public class Electronic {
	private String type;
	private boolean IsWorking;
	private group groupUsing;
	private static int id;
	public int myID;
	private String summary;
	public Electronic(){
		type="Arduino";
		IsWorking=true;
		groupUsing=new group(0);
	}
	public Electronic(String type,group g) {
		this.type=type;
		IsWorking=true;
		groupUsing=g;
		myID=id;
		id++;
		summary="";
	}
	public Electronic(String type, boolean working, group g) {
		this.type=type;
		IsWorking=working;
		groupUsing=g;
		myID=id;
		id++;
		summary="";
	}
	public boolean equals(Electronic other){
		return type.equals(other.getType());
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
		if(!IsWorking){
			System.out.println(summary);
		}
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
