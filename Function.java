public class Function {
	
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
	
	
/*###### YAZILAN EK METOTLAR ######*/
	
/*	Polinomun derecesini doner.	  */
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
	
	
	
/*	Karakter '+'/'-' ise true doner.  */
	public static boolean isSign(char c) {
		return c == '+' || c == '-';
	}
	
	
	
/*	Polinomdaki son '+'/'-' karaterinin indexini doner.  */
	private int lastSign(String s) {
		for(int i = s.length() - 1; i >= 0; i--) {
			if(isSign(s.charAt(i))) {
				return i;
			}
		}
		return -1;
	}
	
/*	Polinomdaki ilk '+'/'-' karaterinin indexini doner.  */
	private int firstSign(String s) {
		for(int i = 0; i <= s.length() - 1; i++) {
			if(isSign(s.charAt(i))) {
				return i;
			}
		}
		return -1;
	}
	
}
