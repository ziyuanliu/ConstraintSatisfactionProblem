import java.util.ArrayList;
import java.util.HashMap;



public class CSP {

	int numOfCalls;
	public CSP(){
		this.numOfCalls = 0;
	}
	
	public Variables backtrack(Variables vars, Constraints con, Domain dom){
		if(vars.isComplete()){
			return vars;
		}
		
//		Node var = vars.getUnsetNode();
		Node var = vars.MRV(con,dom);
		
		if(var==null){
			return null;
		}
		
//		for(int i: dom.nextValues(var, vars, con)){
		for(int i: dom.LCV(var, vars, con)){
			this.numOfCalls++;
//			System.out.println("trying "+var+" with value "+i);

			if(!var.blackList.contains(i)&&con.isLegal(var, vars, i)){

				var.set(i);
//				System.out.println("legal \n"+vars+" added "+var);
				if(forward(vars,con,dom,var)){
					Variables result = backtrack(vars,con,dom);
					if(result!=null){
						return result;
					}
				}
			}
			var.unset();
			undoForward(vars);
			
		}
		return null;
	}
	
	public boolean forward(Variables vars, Constraints con, Domain dom, Node var){
//		System.out.println("Now that "+var+" "+var.getNeighbors().size());
		
		for(int ind: var.getNeighbors()){
			Node temp = vars.getByIndex(ind);
			if(!temp.isSet()){
				ArrayList<Integer> tempList =  new ArrayList<Integer>();
				for(int val:dom.allowable){
					if(!con.isLegal(temp, vars, val)){
//						System.out.println("\t"+val+" is not going to be consistent for "+temp);
						tempList.add(val);
					}
				}
				if(tempList.size()==dom.allowable.length){
					return false;
				}else{
					temp.prune(tempList);
					if(!MAC(vars,dom)){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean MAC(Variables vars, Domain dom){
		//are the set variables sharing any domains at all?
		//basically looks one step further
		ArrayList<Node> list = vars.variables;
		for(Node temp: list){
			if(temp.blackList.size()==dom.allowable.length-1){
				for(Node temp1:list){
					if(!temp.equals(temp1)&&temp1.blackList.size()==dom.allowable.length-1
							&&temp.blackList.equals(temp1.blackList)){
//						System.out.println("\t\tMAC'd "+temp.label+" "+temp.blackList+" "+temp1.label+" "+temp1.blackList);
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void undoForward(Variables vars){
		for(Node ind: vars.variables){
			if(ind.lastPrune.size()!=0){
				ind.unPrune();
			}
		}
	}
}
