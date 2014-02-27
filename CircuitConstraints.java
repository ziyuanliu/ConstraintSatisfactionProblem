import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class CircuitConstraints extends Constraints {
	
	public CircuitConstraints(){
		super();
	}
	
	@Override
	public int numOfLegalMoves(int ind, Variables vars, int[] moves){
		Node var = vars.getByIndex(ind);
		int ctr=0;
		if(var.getNeighbors()!=null&&var.getNeighbors().size()==0){
			return moves.length;
		}
		
		for(int currVal:moves){
//			System.out.println("moves "+currVal);
			if(this.isLegal(var, vars, currVal)){
				ctr++;
			}
		}
		return ctr;
	}
	
	@Override
	public boolean isLegal(Node var, Variables vars, int currVal){
		CircuitNode cVar = (CircuitNode)var;
		CircuitVariables cVars = (CircuitVariables)vars;
		int[] loc = cVars.valToCoordinate(currVal);
		cVars.updateBoard();
		int width = cVars.width;
		int height = cVars.height;
		for(int i = loc[0]; i < loc[0]+cVar.width; i ++){
			for(int j = loc[1]; j < loc[1]+cVar.height; j ++){
				if(i>=width||j>=height||cVars.circuitBoard[i][j]!='.'){
					return false;
				}
			}
		}
		
		return true;
	}
}
