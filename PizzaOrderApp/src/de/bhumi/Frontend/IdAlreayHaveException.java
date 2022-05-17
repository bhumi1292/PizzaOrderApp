package de.bhumi.Frontend;

@SuppressWarnings("serial")
public class IdAlreayHaveException extends RuntimeException {
	
	public IdAlreayHaveException(long id) {
		super("This object has ID" +id);
	}
}
