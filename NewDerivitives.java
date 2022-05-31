class Derivative {
	
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
		
		if(f.getF().equals("sin(x)")){
			temp = "cos(x)";
			Function derivative = new Function(temp);		
			return derivative;
			
		}
		if(f.getF().equals("cos(x)")){
			temp = "-sin(x)";
			Function derivative = new Function(temp);		
			return derivative;
			
		}if(f.getF().equals("tan(x)")){
			temp = "sec(x)^2";
			Function derivative = new Function(temp);		
			return derivative;
			
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




 class Function {
	
	public String f;
	
	public Function() {
		f = "";
	}
	
	public Function(String s) {
		f = s;
	}
	
	
	
	public double evaluate(double x) {
		int p = largestPower(f);
		double result = 0;
		
		for(int i = p; i >= 0; i--) {
			result = result + getCoef(i) * Math.pow(x, i);
		}
		
		return result;
	}
	
	
	
	public int getCoef(int power) {
		int index1 = 0, index2 = 0;
		String temp;
		
		if(power == 0) {
			index1 = lastSign(f);
			index2 = f.lastIndexOf('x');
			
			if(index2 > index1) {
				return 0;
			}
			
			if(index1 == -1) {
				return Integer.parseInt(f);
			}
			
			else {
				if(f.charAt(index1) == '-')
					return (-1)*Integer.parseInt(f.substring(index1 + 1));
				else return Integer.parseInt(f.substring(index1 + 1));
			}
		}
		
		
		if(power == 1) {
			index1 = f.lastIndexOf('x');
			temp = f + " ";
			
			if (index1 == -1)
				return 0;
			
			if( (index1 == 0) && temp.charAt(index1 + 1) != '^' ) {
				return 1;
			}
			
			if(temp.charAt(index1 + 1) != '^') {
				if(isSign(temp.charAt(index1 - 1))) {
					if(temp.charAt(index1 - 1) == '-')
						return -1;
					return 1;
				}
				else {
					temp = temp.substring(0, index1);
					index2 = lastSign(temp);
							
					if(index2 >= 0 && temp.charAt(index2) == '-')
						return (-1)*Integer.parseInt(temp.substring(index2 + 1));
					else return Integer.parseInt(temp.substring(index2 + 1));
				}
			}
			
			return 0;
		}
		
		
		if(power > 1) {
			temp = "x^" + power;
			index1 = f.indexOf(temp);
			
			if(index1 == -1)
				return 0;
			
			else if(index1 == 0)
				return 1;
			
			else if( index1 > 0 && isSign(f.charAt(index1 - 1)) ) {
				if(f.charAt(index1 - 1) == '-')
					return -1;
				return 1;
			}
			
			else {
				for(int i = index1; i >= 0; i--) {
					if( (i == 0) || ( (i > 0) && isSign(f.charAt(i - 1)) ) ) {
						index2 = i;
						break;
					}
				}
				
				if(index2 - 1 >= 0 && f.charAt(index2 - 1) == '-')
					return (-1)*Integer.parseInt( f.substring(index2, index1) );
				else
					return Integer.parseInt( f.substring(index2, index1) );
			}
		}
		
		return 0;
	}
	
	
	public int largestPower(String s) {
		int index = s.indexOf("^");
		String temp;
		
		if(index == -1) {
			index = f.indexOf('x');
			if(index == -1)
				return 0;
			else
				return 1;
		}
		
		temp = s.substring(index + 1);
		index = firstSign(temp);
		
		if (index == -1)
			return Integer.parseInt(temp);
		
		return Integer.parseInt(temp.substring(0, index));
	}
	
	
	public static boolean isSign(char c) {
		return c == '+' || c == '-';
	}
	
	
	private int lastSign(String s) {
		for(int i = s.length() - 1; i >= 0; i--) {
			if(isSign(s.charAt(i))) {
				return i;
			}
		}
		return -1;
	}
	
	private int firstSign(String s) {
		for(int i = 0; i <= s.length() - 1; i++) {
			if(isSign(s.charAt(i))) {
				return i;
			}
		}
		return -1;
	}
	
	public String getF(){
		
		return f;
	}
	
}
class Exponential{
		String input, ans;
		public Exponential(String in){
			input =in; 
		}
		public String getDerivitive(){
			for(int i = 0; i < input.length(); i++){
					if(input.substring(i, i+1).equals("^")){
						ans = input.substring(0, i);
						break;
						
					}
				
			}
			
			 return (input+"ln("+ans+")");
			
		}
		
		
		
	
}
class Product{
		String in, ans;
		
		public Product(String input, String input2){
			in = input;		
			ans = input2;
		}
		public String getDerivitive(){
		
		Function test1 = new Function(in);
		Function test2 = new Function(ans);
		Derivative first = new Derivative(test1);
		Derivative second = new Derivative(test2);
		
		return in + "*" + second.findDerivative(test2).getF() + "+"  + first.findDerivative(test1).getF() + "*" + ans;
		
		}
		
	
	
}

class QuotientRule{
		String in, ans;
		public QuotientRule(String input, String input2){
			in = input;		
			ans = input2;
		}
		
	    public String getDerivative(){
			Function test1 = new Function(in);
		Function test2 = new Function(ans);
		Derivative first = new Derivative(test1);
		Derivative second = new Derivative(test2);
		
		
		return ans + "*" + first.findDerivative(test1).getF() + "-"  + in + "*" + second.findDerivative(test2).getF() + "/" + "("+ ans + ")"+ "^2";
			
		}
		
		

	
	
}

public class NewDerivitives{
	
 public static void main(String[] args) {
			//Complete power rule
			Function test1 = new Function("sin(x)");
			Derivative test2 = new Derivative(test1);
			System.out.println(test2.findDerivative(test1).getF());
			//Exponential rule 
			Exponential test3 = new Exponential("2000000^x");
			System.out.println(test3.getDerivitive());
			//product rule 
			Product test4 = new Product("2x", "2x^5");
			System.out.println(test4.getDerivitive());
			//Quotient rule 
			QuotientRule test5 = new QuotientRule("2x", "2x^5");
			System.out.print(test5.getDerivative());
			//Derivative test3 = test2.findDerivative(test1);
			
			
			
	
	}
}