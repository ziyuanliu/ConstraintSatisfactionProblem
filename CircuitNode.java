import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircuitNode extends Node{
		String label; 
		int width;
		int height;
		
		public CircuitNode(String label,int index, int width, int height){
			super(label,index);
			this.label = label;
			this.value = -1;
			this.width = width;
			this.height = height;
		}
	
		public void rotate(){
			int temp = this.width;
			this.width = this.height;
			this.height = temp;
		}
		
		@Override
		public String toString(){
			return this.isSet() ? "Node: "+label.trim()+" value: "+value+" "+this.width+" by "+this.height : "Node: "+label.trim()+" "+this.width+" by "+this.height;
		}
		
//		"a:3,2-b:5,2-c:2,3-e:7,1"
		public static List<Node> createFromString(String str){
			ArrayList<Node> retval = new ArrayList<Node>();
			
			String[] nodes = str.split("-");
			
			if(nodes.length<1){
				System.out.println("bad formatting");
				return null;
			}
			
			for(int i = 0; i < nodes.length; i ++){
				String[] nodeParts = nodes[i].split(":");
				String[] dim = nodeParts[1].split(",");
				retval.add(new CircuitNode(nodeParts[0],i,Integer.parseInt(dim[0]),Integer.parseInt(dim[1])));
			}
//			Collections.reverse(retval);

			for(Node temp: retval){
				ArrayList<Integer> n = new ArrayList<Integer>();
				for(Node temp1: retval){
					if(!temp1.equals(temp)){
						n.add(temp1.index);
					}
				}
				temp.setNeighbors(n);
			}
			
			return retval;
		}
	}