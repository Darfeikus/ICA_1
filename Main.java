import java.util.Scanner;
import java.util.ArrayList;

class Main{
	public static BigNumber operation(int i,BigNumber x, BigNumber y){
		switch(i){
			case 1:
				return (x).add(y);
			case 2:
				return (x).subs(y);
			case 3:
				return (x).mult(y);
			case 4:
				return (x).div(y);
			case 5:
				return (x).mod(y);
		}
		return new BigNumber();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<BigNumber> bNumbers = new ArrayList<BigNumber>();
		ArrayList<String> instrucciones = new ArrayList<String>();
		int position = 0;
		while(s.hasNextLine()){	
			String temp = s.nextLine();
			try{
				BigNumber myNumber =  new BigNumber(temp);
				bNumbers.add(myNumber);
			}
			catch(InvalidBigNumberException e){
				System.out.println("Error in : " + temp);
				System.out.println(e);
				bNumbers.add(new BigNumber());
			}
			catch(BigNumberOverflowException x){
				System.out.println("Error in : " + temp);
				System.out.println(x);
				bNumbers.add(new BigNumber());
			}
		}
		instrucciones.add("331");
		instrucciones.add("213");
		instrucciones.add("445");
		instrucciones.add("321");
		instrucciones.add("123");
		instrucciones.add("344");
		instrucciones.add("351");
		instrucciones.add("434");
		System.out.println("\n\nOperations : \n\n");
		for (int i = 0;i<instrucciones.size();i++) {
			try{
				String insActual = instrucciones.get(i);
				BigNumber first = bNumbers.get(Character.getNumericValue(insActual.charAt(0))-1);
				BigNumber second = bNumbers.get(Character.getNumericValue(insActual.charAt(2))-1);
				System.out.println(operation(Character.getNumericValue(insActual.charAt(1)),first,second));
			}
			catch(InvalidBigNumberException e){
				System.out.println(e);
			}
			catch(BigNumberOverflowException x){
				System.out.println(x);
			}
			catch(ArithmeticException j){
				System.out.println(j);
			}
		}
	}
}