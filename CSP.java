import java.util.ArrayList;


public class CSP {

	
	public Variables search(Variables vars, Constraints con, Domain dom){
		return backtrack(vars, con, dom);
	}

	public Variables backtrack(Variables vars, Constraints con, Domain dom){
		if(vars.isComplete()){
			return vars;
		}
		
		Node var = vars.getUnsetNode();
		System.out.println("current unset is "+var);
		for(int i: dom.nextValues(var, vars, con)){
			System.out.println("next value is "+i);
			if(con.isLegal(var, vars, i)){
				var.set(i);
				System.out.println("it was legal to set "+var);
				Variables result = backtrack(vars,con,dom);
				if(result!=null){
					return result;
				}
				var.unset();
			}
		}
		return null;
	}
}
