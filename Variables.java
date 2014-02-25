import java.util.ArrayList;


public class Variables {
	ArrayList<Node> variables;
	
	public Variables(ArrayList<Node> variables){
		this.variables = variables;
	}
	
	public Node getUnsetNode(){
		for(Node temp:this.variables){
			if(!temp.isSet){
				return temp;
			}
		}
		return null;
	}
	
	public boolean isComplete(){
		for(Node temp: this.variables){
			if(!temp.isSet){
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
