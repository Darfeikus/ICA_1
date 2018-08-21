/*
	ICA_1
	Oscar Barbosa Aquino A01329173
	Antonio Diaz Flores A01329256
*/
	/*Class that throws an exception in case of an Aritmetic
	problem*/

class ArithmeticException extends RuntimeException{

	public ArithmeticException(){
		this("Invalid Arithmetic Operation");
	}

	public ArithmeticException(String m){
		super(m);
	}

}