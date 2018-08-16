import java.util.Scanner;
class Main2{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try{
			System.out.println(new BigNumber(s.nextLine()).div(new BigNumber(s.nextLine())));
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