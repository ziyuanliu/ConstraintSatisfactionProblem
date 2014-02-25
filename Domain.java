import java.util.ArrayList;


public class Domain {
	int[] allowable;
	
	public Domain(int[] allowable){
		this.allowable = allowable;
	}
	
	public ArrayList<Integer> nextValues(Node var, Variables vars, Constraints con){
		ArrayList<Integer> retval = new ArrayList<Integer>();
		for(int i: allowable){
			if(!var.isSet()){
				retval.add(i);
			}
		}
		return retval;
	}
}
