import java.util.ArrayList;
import java.util.List;

public class Node{
		String label; 
		ArrayList<Node> neigbors;
		boolean isSet;
		int value;
		
		public Node(String label){
			this.label = label;
			this.isSet = false;
		}
	
		public void set(int value){
			this.isSet = true;
			this.value = value;
		}
		
		public void unset(){
			this.isSet = false;
		}
		
		public void setNeighbors(ArrayList<Node> neighbors){
			this.neigbors = neighbors;
		}
		
		public ArrayList<Node> getNeighbors(){
			return this.neigbors;
		}
		
		public String toString(){
			return isSet?"Node: "+label+" value: "+value+" neighbors: "+this.neigbors.size() : "Node: "+label+" neighbors: "+this.neigbors.size();
		}
		
		public int getVal(){
			return this.isSet? this.value:0;
		}
		
		
		// format "Western Australia, Northern Territory, South Australia, 
		//		Queensland, New South Wales, Victoria, Tasmania:
		//		1 2-0 2 3-0 1 3 4 5-1 2 4 5-2 3 5-2 4-n-"
		public static List<Node> createFromString(String str){
			ArrayList<Node> retval = new ArrayList<Node>();
			
			String[] two = str.split(":");
			
			if(two.length!=2){
				System.out.println("bad formatting");
				return null;
			}
			
			String[] nodeNames = two[0].split(",");
			
			for(String name:nodeNames){
				retval.add(new Node(name.trim()));
			}
			
			String[] rel = two[1].split("-");
			
			if(rel.length!=retval.size()){
				System.out.println("bad formatting");
				return null;
			}
			
			for(int i = 0; i < retval.size(); i ++){
				String[] nodes = rel[i].split(" ");
				ArrayList<Node> tempArray = new ArrayList<Node>();
				for(String number: nodes){
					if(number.equalsIgnoreCase("n")){
						tempArray = new ArrayList<Node>();
						break;
					}
					tempArray.add(retval.get(Integer.parseInt(number)));
				}
				Node temp = retval.get(i);
				temp.setNeighbors(tempArray);
			}
			return retval;
		}
	}