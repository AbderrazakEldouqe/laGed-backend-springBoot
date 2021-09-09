package uemf.org.Exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiBaseException{
	
	
	public BadRequestException(String message) {
		super(message);
	}


	public HttpStatus getStatusCode()
	{
		return HttpStatus.BAD_REQUEST;
	}


	@Override
	public int getStatusCodeValue() {

		return HttpStatus.BAD_REQUEST.value();
	}
	

}
