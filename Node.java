import java.util.ArrayList;
import java.util.List;

public class Node{
		String label; 
		ArrayList<Integer> neigbors;
		int value;
		int index;
		
		public Node(String label, int index){
			this.label = label;
			this.value = -1;
			this.index = index;
		}
	
		public void set(int value){
			this.value = value;
		}
		
		public void unset(){
			this.value = -1;
		}
		
		public boolean isSet(){
			return this.value>-1;
		}
		
		public void setNeighbors(ArrayList<Integer> neighbors){
			this.neigbors = neighbors;
		}
		
		public ArrayList<Integer> getNeighbors(){
			return this.neigbors;
		}
		
		public String toString(){
			return this.isSet() ? "Node: "+label+" value: "+value+" neighbors: "+this.neigbors.size() : "Node: "+label+" neighbors: "+this.neigbors.size();
		}
		
		public int getVal(){
			return this.isSet() ? this.value : -1;
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
			
			for(int i = 0; i < nodeNames.length; i++){
				retval.add(new Node(nodeNames[i],i));
			}
			
			String[] rel = two[1].split("-");
			
			if(rel.length!=retval.size()){
				System.out.println("bad formatting");
				return null;
			}
			
			for(int i = 0; i < retval.size(); i ++){
				String[] nodes = rel[i].split(",");
				ArrayList<Integer> tempArray = new ArrayList<Integer>();
				for(String number: nodes){
					if(number.equalsIgnoreCase("n")){
						tempArray = new ArrayList<Integer>();
						break;
					}
					tempArray.add(Integer.parseInt(number));
				}
				Node temp = retval.get(i);
				temp.setNeighbors(tempArray);
			}
			return retval;
		}
	}