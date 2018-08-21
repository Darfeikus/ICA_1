/*
	ICA_1
	Oscar Barbosa Aquino A01329173
	Antonio Diaz Flores A01329256
*/


import java.util.Scanner;
import java.util.ArrayList;

class Main{

	/*Class that interprets the operations*/

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

	/*Class Main that handles exceptions*/

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<BigNumber> bNumbers = new ArrayList<BigNumber>();
		ArrayList<String> instructions = new ArrayList<String>();
		int position = 0;
		while(s.hasNextLine()){	
			String temp = s.nextLine();
			try{
				BigNumber myNumber =  new BigNumber(temp);
				bNumbers.add(myNumber);
			}
			catch(InvalidBigNumberException e){
				System.out.println("Error in : " + temp + "\n\n");
				System.out.println(e);
				bNumbers.add(new BigNumber());
			}
			catch(BigNumberOverflowException x){
				System.out.println("Error in : " + temp + "\n\n");
				System.out.println(x);
				bNumbers.add(new BigNumber());
			}
		}
		instructions.add("331");
		instructions.add("213");
		instructions.add("445");
		instructions.add("321");
		instructions.add("123");
		instructions.add("344");
		instructions.add("351");
		instructions.add("434");
		for (int i = 0;i<instructions.size();i++) {
			try{
				String insActual = instructions.get(i);
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