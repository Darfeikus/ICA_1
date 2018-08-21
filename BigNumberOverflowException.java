/*
	ICA_1
	Oscar Barbosa Aquino A01329173
	Antonio Diaz Flores A01329256
*/

	/*Class that throws an exception in case of an Overflow*/

class BigNumberOverflowException extends RuntimeException{

	public BigNumberOverflowException(){
		this("Big Number Overflow");
	}

	public BigNumberOverflowException(String m){
		super(m);
	}

}