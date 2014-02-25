import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Constraints {
	HashMap<Integer,ArrayList<int[]>> constraint;
	
	public Constraints(HashMap<Integer,ArrayList<int[]>> constraint){
		this.constraint = constraint;
	}
	
	public boolean isSatisfied(int[] key, int[] value){
		for(int[] temp:constraint.get(Arrays.hashCode(key))){
			if(Arrays.equals(temp, value)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isLegal(Node var, Variables vars, int currVal){
		for(int temp: var.getNeighbors()){
			int neighborVal = vars.getByIndex(temp).getVal();
			System.out.println("testing "+var.index+", "+temp+" | "+currVal+", "+neighborVal);
			if(neighborVal>-1&&!this.isSatisfied(new int[]{var.index,temp}, new int[]{currVal, neighborVal})){
				return false;
			}
		}
		return true;
	}
	
//	{(0 , 1 ), (0 , 2 ), (1 , 0 ), (1 , 2 ), (2 , 0 ), (2 , 1 )} 
	// 0,1:0,1-0,2-1,0-1,2-2,0-2,1
	public static Constraints constraintsFactory(ArrayList<Node> assignment,String str){
		HashMap<Integer,ArrayList<int[]>> cons = new HashMap<Integer,ArrayList<int[]>> ();

		ArrayList<int[]> valueList = new ArrayList<int[]>();
		for(String val:str.split("-")){
			valueList.add(new int[]{Integer.parseInt(val.split(",")[0].trim()),
					Integer.parseInt(val.split(",")[1].trim())});
		}
		
		for(Node temp: assignment){
			for(int n: temp.getNeighbors()){
				int[] key = new int[]{temp.index,n};
				cons.put(Arrays.hashCode(key), valueList);
			}
		}
		
		return new Constraints(cons);
	}

}
