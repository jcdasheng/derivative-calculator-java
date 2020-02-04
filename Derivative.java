public class Derivative {
	
	Function func;
	
	public Derivative() {
		
	}
	
	public Derivative(Function f) {
		func = f;
	}
	
	
	
	public Function findDerivative(Function f) {
		String temp = "";
		int power = f.largestPower(f.f);
		
		if(power == 0) {
			temp  = "0";
		}
		
		for(int i = power; i > 2; i--) {
			if(f.getCoef(i) != 0) {
				if(f.getCoef(i) > 0)
					temp = temp + "+" + f.getCoef(i)*i + "x^" + (i - 1);
				else
					temp = temp + f.getCoef(i)*i + "x^" + (i - 1);	
			}
		}
		
		temp = removeSign(temp);
			
		if(f.getCoef(2) != 0) {
			temp = temp + "+" + f.getCoef(2)*2 + "x";
		}
		
		if(f.getCoef(1) != 0) {
			if(f.getCoef(1) < 0)
				temp = temp +  f.getCoef(1);
			else
				temp = temp + "+" + f.getCoef(1);
		}
		
		temp = removeSign(temp);
		Function derivative = new Function(temp);
		
		return derivative;
	}
	
	
	/*###### YAZILAN EK METOTLAR ######*/
	
/*	Verilen String'i, varsa sonundaki '+'/'-' ve basindaki '+' karakterlerini atarak doner.  */
	public String removeSign(String s) {
		
		if( s.length() > 0 && Function.isSign(s.charAt(s.length() - 1)) ) {
			s = s.substring(0, s.length() - 1);
		}
		
		if( s.length() > 0 && s.charAt(0) == '+' ) {
			s = s.substring(1, s.length());
		}
		
		return s;
	}
	
}
