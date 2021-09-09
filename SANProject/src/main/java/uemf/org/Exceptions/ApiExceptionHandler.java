package uemf.org.Exceptions;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import uemf.org.Models.ErrorDTO;
import uemf.org.Services.ErrorService;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler
{
	@Autowired
	ErrorService errorService;

	@ExceptionHandler(ApiBaseException.class)
	public ResponseEntity<ErrorDTO> handleApiException(ApiBaseException ex, WebRequest req)
	{
		ErrorDTO errorDetails= errorService.getErrorByCodeError(ex.getStatusCodeValue());
		errorDetails.setUri(req.getDescription(false));
		errorDetails.setTimestamp(new Date());
		return new ResponseEntity<>(errorDetails, ex.getStatusCode());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
