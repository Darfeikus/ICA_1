class BigNumberOverflowException extends RuntimeException{

	public BigNumberOverflowException(){
		this("Big Number Overflow");
	}

	public BigNumberOverflowException(String m){
		super(m);
	}

}