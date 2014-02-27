import java.util.ArrayList;


public class driver {
	public static void main(String[] args){
//		MapColoringCSP csp = new MapColoringCSP();
		CircuitCSP csp = new CircuitCSP();

		long startTime = System.nanoTime();
		
		csp.run();
		long endTime = System.nanoTime();

		long duration = endTime - startTime;
		System.out.println("took: "+duration/1000000000.0f+" seconds");
	}
}
