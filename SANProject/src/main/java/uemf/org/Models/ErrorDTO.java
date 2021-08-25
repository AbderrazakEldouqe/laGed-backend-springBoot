package uemf.org.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class ErrorDTO {

	private int code;
	private String message;
	private String typeErreur;
	private String info;
}
