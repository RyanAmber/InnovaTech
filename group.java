package ClientProject;
import java.util.*;
public class group {
	private List<String> students;
	private List<Electronic> items;
	private int team;
	public group(int team){
		students=new ArrayList<String>();
		this.team=team;
	}
	public group(List<String> members, int team) {
		students=List.copyOf(members);
		this.team=team;
	}
	public void addMember(String student) {
		students.add(student);
	}
	public String toString() {
		return team+"";
	}
	public int getTeamNum() {
		return team;
	}
}
