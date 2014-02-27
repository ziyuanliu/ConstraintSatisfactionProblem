import java.util.ArrayList;


public class CircuitVariables extends Variables{
	char[][] circuitBoard;
	int width; 
	int height;
	
	public CircuitVariables(ArrayList<Node> variables, int width, int height){
		super(variables);
		this.width = width;
		this.height = height;
		resetBoard();
	}
	
	public void resetBoard(){
		circuitBoard = new char[width][height];
		for(int i = 0; i < width; i ++){
			for(int j = 0; j < height; j++){
				circuitBoard[i][j]='.';
			}
		}
	}
	
	public int[] valToCoordinate(int val){
		int x = val%width;
		int y = (val-x)/width;
		return new int[]{x,y};
	}
	
	public void updateBoard(){
		resetBoard();
		for(int ctr = 0; ctr < variables.size(); ctr ++){
			CircuitNode temp = (CircuitNode) variables.get(ctr);
			if(temp.isSet()){
				char label = temp.label.charAt(0);
				int[] coords = this.valToCoordinate(temp.value);
				int x = coords[0];
				int y = coords[1];
				for(int i = x; i < x+temp.width; i++){
					for(int j = y; j < y+temp.height; j++){
						circuitBoard[i][j] = label;
					}
				}
			}
		}
	}
	
	
	@Override
	public String toString(){
		this.updateBoard();
		StringBuilder strBld = new StringBuilder();
		for(int i = 0; i < height; i++)
		   {
		      for(int j = 0; j < width; j++)
		      {
		         strBld.append(circuitBoard[j][i]);
		      }
		      strBld.append('\n');
		   }
		
		return strBld.toString();
	}
}
