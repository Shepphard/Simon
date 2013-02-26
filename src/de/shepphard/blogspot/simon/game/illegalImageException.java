package de.shepphard.blogspot.simon.game;

public class illegalImageException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public illegalImageException(){
		super("");
	}
	
	public illegalImageException(String s){
		super(s);
	}

}
