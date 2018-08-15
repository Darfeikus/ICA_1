class ArithmeticException extends RuntimeException{

	public ArithmeticException(){
		this("Invalid Arithmetic Operation");
	}

	public ArithmeticException(String m){
		super(m);
	}

}