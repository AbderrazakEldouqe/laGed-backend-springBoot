package uemf.org.Models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class ErrorDTO {

	private int codeError;
	private String message;
	private String typeErreur;
	private String info;
	private String uri;
	@JsonFormat(shape= JsonFormat.Shape.STRING , pattern= "dd-MM-yyyy hh:mm:ss")
	private Date timestamp = new Date();
	
	
	
	
}
