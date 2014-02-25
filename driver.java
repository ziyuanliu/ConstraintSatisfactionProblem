import java.util.ArrayList;


public class driver {
	public static void main(String[] args){
		ArrayList<Node> assignment = 
				(ArrayList<Node>) Node.createFromString("Western Australia, Northern Territory, " +
						"South Australia, Queensland, New South Wales, Victoria, " +
				"Tasmania:1 2-0 2 3-0 1 3 4 5-1 2 4 5-2 3 5-2 4-n-");
		Variables vars = new Variables(assignment);
		System.out.println(vars);
		
		ArrayList<Integer> allowables = new ArrayList<Integer>();
		allowables.add(0);
		allowables.add(1);
		allowables.add(2);
		Domain dom = new Domain(allowables);
		Constraints cons = new Constraints();
		
		CSP csp = new CSP();
		Variables result = csp.search(vars,cons,dom);
		System.out.println(result);
	}
}
