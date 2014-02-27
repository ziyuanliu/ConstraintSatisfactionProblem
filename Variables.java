import java.util.ArrayList;


public class Variables {
	ArrayList<Node> variables;
	
	public Variables(ArrayList<Node> variables){
		this.variables = variables;
	}
	
	public Node getUnsetNode(){
		for(Node temp:this.variables){
			if(!temp.isSet()){
				return temp;
			}
		}
		return null;
	}
	
	public Node MRV(Constraints con, Domain dom){
		int min = Integer.MAX_VALUE;
		int ind = -1;
		for(Node temp:this.variables){
			if(!temp.isSet()&&temp.value==-1){

				int i = con.numOfLegalMoves(temp.index, this, dom.allowable);
				if(i<min&&i!=0){
					ind = temp.index;
					min = i;
//					System.out.println("node value "+this.getByIndex(temp.index).label+" val "+temp.label);

				}
			}
		}
		return ind==-1?null:this.getByIndex(ind);
	}
	
	public Node getByIndex(int i){
		return variables.get(i);
	}
	
	public boolean isComplete(){
		for(Node temp: this.variables){
			if(!temp.isSet()){
				return false;
			}
		}
		return true;
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		for(Node temp: variables){
			str.append(temp.toString()+"\n");
		}
		return str.toString();
	}
}
