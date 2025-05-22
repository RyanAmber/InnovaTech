//package ClientProject;

public class Electronic {
	private String type;
	private boolean IsWorking;
	private group groupUsing;
	public int myID;
	private String summary;
	private boolean Check;
	public Electronic(){
		type="Arduino";
		IsWorking=true;
		groupUsing=new group(0);
	}
	public Electronic(String type,group g, int ID) {
		this.type=type;
		IsWorking=true;
		groupUsing=g;
		summary="";
		myID=ID;
	}
	public Electronic(String type, boolean working, group g,int ID) {
		this.type=type;
		IsWorking=working;
		groupUsing=g;
		summary="";
		myID=ID;
	}
	public String fileFormat(){
		return type+" "+IsWorking+" "+groupUsing.getTeamNum()+" "+myID;
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
	public void setCheck(boolean check) {
		Check=check;
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
