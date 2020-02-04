public class NewtonRaphson {

	public NewtonRaphson() {
		
	}
	
	public double findRoot(Function f, double startingPoint) {
		double endPoint = 0.0;
		Derivative d = new Derivative(f);

		while (Math.abs(startingPoint - endPoint) > 0.009) {
			endPoint =  (startingPoint - f.evaluate(startingPoint)/d.findDerivative(f).evaluate(startingPoint));
			startingPoint=endPoint;	
		}
		
		return endPoint;
	}
	
}
