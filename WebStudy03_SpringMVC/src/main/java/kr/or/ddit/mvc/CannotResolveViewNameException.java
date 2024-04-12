package kr.or.ddit.mvc;

public class CannotResolveViewNameException extends RuntimeException{

	public CannotResolveViewNameException() {
		super();
	}

	public CannotResolveViewNameException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CannotResolveViewNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public CannotResolveViewNameException(String message) {
		super(message);
	}

	public CannotResolveViewNameException(Throwable cause) {
		super(cause);
	}
	
}
