import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Constraints {
	
	public Constraints(){
	}
	
	public int numOfLegalMoves(int ind, Variables vars, int[] moves){
		Node var = vars.getByIndex(ind);
		int ctr=0;
		if(var.getNeighbors().size()==0){
			return moves.length;
		}
		
		for(int currVal:moves){
			if(this.isLegal(var, vars, currVal)){
				ctr++;
			}
		}
		
		return ctr;
	}
	
	public boolean isSatisfied(int[] value){
		return (value[0]!=value[1]);
	}
	
	
	public boolean isLegal(Node var, Variables vars, int currVal){
		for(int temp: var.getNeighbors()){
			int neighborVal = vars.getByIndex(temp).getVal();	
			if(!this.isSatisfied(new int[]{currVal, neighborVal})){
				return false;
			}
		}
		return true;
	}
}
