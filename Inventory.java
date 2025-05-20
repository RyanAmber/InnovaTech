//package ClientProject;
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
	public List<Integer> statistics(String type){
		int broken=0;
		int working=0;
		int available=0;
		int borrowed=0;
		int total=0;
		List<Integer> stats=new ArrayList<Integer>();
		for (Electronic e:items){
			if(e.getType().equals(type)){
				total++;
				if (e.getWorking()==false){
					broken++;
				}else{
					working++;
				}
				if(e.getGroup().getTeamNum()==0){
					available++;
				}else{
					borrowed++;
				}
			}
		}
		stats.add(broken);
		stats.add(working);
		stats.add(available);
		stats.add(borrowed);
		stats.add(total);
		return stats;
	}
}
