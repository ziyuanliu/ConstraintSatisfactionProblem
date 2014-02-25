import java.util.ArrayList;


public class Domain {
	ArrayList<Integer> allowable;
	
	public Domain(ArrayList<Integer> allowable){
		this.allowable = allowable;
	}
	
	public ArrayList<Integer> nextValues(Node var, Variables vars, Constraints con){
		ArrayList<Integer> retval = new ArrayList<Integer>();
		for(int i: allowable){
			if(!var.isSet||i!=var.value){
				retval.add(i);
			}
		}
		return retval;
	}
}
