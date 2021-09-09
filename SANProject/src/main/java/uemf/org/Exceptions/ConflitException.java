package uemf.org.Exceptions;

import org.springframework.http.HttpStatus;

public class ConflitException extends ApiBaseException{

	public ConflitException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public HttpStatus getStatusCode() {
		
		return HttpStatus.CONFLICT;
	}


	@Override
	public int getStatusCodeValue() {
		
		return HttpStatus.CONFLICT.value();
	}

}
