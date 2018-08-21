/*
	ICA_1
	Oscar Barbosa Aquino A01329173
	Antonio Diaz Flores A01329256
*/

	/*Class that throws an exception in case of an Invalid 
	Big	Number*/

class InvalidBigNumberException extends RuntimeException{

	public InvalidBigNumberException(){
		this("Invalid Big Number");
	}

	public InvalidBigNumberException(String m){
		super(m);
	}

}