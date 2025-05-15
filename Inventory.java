package ClientProject;
import java.util.*;
public class Inventory {
	private List<Electronic> items;
	public Inventory() {
		items=new ArrayList<Electronic>();
	}
	public Inventory(ArrayList<Electronic> list) {
		items=List.copyOf(list);
	}
	public void addItem(Electronic item) {
		items.add(item);
	}
	public String toString() {
		if (items.size()==0) {
			return "";
		}
		String total=items.get(0)+"";
		for (int i=1;i<items.size();i++) {
			total+="\n"+items.get(i);
		}
		return total;
	}
	public Electronic get(int index) {
		return items.get(index);
	}
	public int locate(int ID) {
		for (Electronic e:items) {
			if (e.myID==ID) {
				return e.getGroup().getTeamNum();
			}
		}
		return 0;
	}
}
