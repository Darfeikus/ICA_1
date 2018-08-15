class InvalidBigNumberException extends RuntimeException{

	public InvalidBigNumberException(){
		this("Invalid Big Number");
	}

	public InvalidBigNumberException(String m){
		super(m);
	}

}