package ClientProject;

public class Electronic {
	private String type;
	private boolean IsWorking;
	private int groupUsing;
	private static int id;
	private int myID;
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
	}
}
