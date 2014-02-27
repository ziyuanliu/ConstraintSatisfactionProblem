import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


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
	
	public ArrayList<Integer> LCV(Node var, Variables vars, Constraints con){
		ArrayList<Integer> retval = new ArrayList<Integer>();
		PriorityQueue<Node> order = new PriorityQueue<Node>();
		for(int i: allowable){
			if(!var.isSet()&&con.isLegal(var, vars, i)){
				int moves = 0;
				Node container = new Node("c",-1);
				container.set(i);
				for(Node temp: vars.variables){
					if(!temp.isSet()){
						moves += con.numOfLegalMoves(var.index, vars, allowable);
					}
				}
				container.setPriority(moves);
				order.add(container);
				var.unset();
			}
		}
		Node temp = order.poll();
		while(temp!=null){
//			System.out.println(temp.priority);
			retval.add(temp.value);
			temp = order.poll();
		}
		return retval;
	}
}
