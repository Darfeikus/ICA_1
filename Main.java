import java.util.Scanner;
import java.util.ArrayList;

class Main{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<BigNumber> bNumbers = new ArrayList<BigNumber>();
		int position = 0;
		while(s.hasNextLine()){	
			try{
				BigNumber myNumber =  new BigNumber(s.nextLine());
				bNumbers.add(myNumber);
			}
			catch(InvalidBigNumberException e){
				System.out.println(e);
			}
		}
		try{
			BigNumber n = bNumbers.get(0).div(bNumbers.get(1));
			System.out.println(n);
		}
		catch(ArithmeticException e){
			System.out.println(e);
		}
		catch(BigNumberOverflowException x){
			System.out.println(x);
		}
		catch(InvalidBigNumberException z){
			System.out.println(z);
		}
	}
}