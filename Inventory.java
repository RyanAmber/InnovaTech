//package ClientProject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;       //Map<String,List<Electronic>
public class Inventory {
	private Map<String,List<Electronic>> items;
	private List<String> types;
	public Inventory() {
		items=new HashMap<String,List<Electronic>>();
		types=new ArrayList<String>();
	}
	public Inventory(HashMap<String,List<Electronic>> list,ArrayList<String> things) {
		items=Map.copyOf(list);
		types=List.copyOf(things);
	}
	public void addItem(Electronic item) {
		if (!items.containsKey(item.getType())){
			items.put(item.getType(),new ArrayList<Electronic>());
			types.add(item.getType());
		}
		items.get(item.getType()).add(item);
	}
	public String toString() {
		if (items.size()==0) {
			return "";
		}
		String total="";
		for (String s:types) {
			for (Electronic e:items.get(s)){
				total+=e+"\n";
			}
		}
		return total;
	}
	public int maxInt() {
		int max=0;
		for (String type:types) {
			for (Electronic e:items.get(type)){
				if (e.myID>max) {
					max=e.myID;
				}
			}
		}
		return max;
	}
	public Electronic get(int ID) {
		for (String type:types) {
			for (Electronic e:items.get(type)){
				if (e.myID==ID) {
					return e;
				}
			}
		}
		return new Electronic();
	}
	public int locate(int ID) {
		for (String type:types) {
			for (Electronic e:items.get(type)){
				if (e.myID==ID) {
					return e.getGroup().getTeamNum();
				}
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
		for (Electronic e:items.get(type)){
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
		stats.add(broken);
		stats.add(working);
		stats.add(available);
		stats.add(borrowed);
		stats.add(total);
		return stats;
	}
}
