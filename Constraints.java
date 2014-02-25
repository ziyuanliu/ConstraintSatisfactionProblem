import java.util.ArrayList;


public class Constraints {
	
	public Constraints(){
		
	}
	
	public boolean isLegal(Node var, Variables vars, int i){
		System.out.println(var);
		for(Node temp: var.getNeighbors()){
			if(temp.isSet&&temp.value==i){
				return false;
			}
		}
		return true;
	}
}
