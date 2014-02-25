import java.util.ArrayList;


public class MapColoringCSP extends CSP{
	Domain dom;
	Variables vars;
	Constraints cons;
	
	public MapColoringCSP(){
		ArrayList<Node> assignment = 
				(ArrayList<Node>) Node.createFromString("Western Australia, Northern Territory, " +
						"South Australia, Queensland, New South Wales, Victoria, " +
				"Tasmania:1,2-0,2,3-0,1,3,4,5-1,2,4,5-2,3,5-2,4-n-");
		this.vars = new Variables(assignment);	
		this.dom = new Domain(new int[]{0,1,2});
		this.cons = Constraints.constraintsFactory(assignment,"0,1-0,2-1,0-1,2-2,0-2,1");
		System.out.println(vars);
		
	}
	public void run(){
		Variables result = backtrack(this.vars,this.cons,this.dom);
		System.out.println(result);

	}
}
