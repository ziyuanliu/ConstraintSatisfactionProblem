import java.util.ArrayList;


public class CircuitCSP extends CSP{
	Domain dom;
	Variables vars;
	Constraints cons;
	
	public CircuitCSP(){
		super();
		ArrayList<Node> assignment = 
				(ArrayList<Node>) CircuitNode.createFromString("a:3,2-b:5,2-c:2,3-d:7,1-e:3,2-f:5,2-g:2,3-h:7,1-i:3,2-j:5,2-k:2,3-l:7,1");
		int width = 10;
		int height = 9;
		this.vars = new CircuitVariables(assignment,width,height);
		int[] allowables = new int[width*height];
		for(int i = 0; i < width*height; i ++){
			allowables[i]=i;
		}
		this.cons = new CircuitConstraints();
		this.dom = new Domain(allowables);
		System.out.println(vars);
		
	}
	public void run(){
		
		Variables result = backtrack(this.vars,this.cons,this.dom);
		System.out.println(result);
		System.out.println("Number of calls: "+this.numOfCalls);
	}
}
