package uemf.org.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Errors")
@Entity
@Getter @Setter 
@AllArgsConstructor @NoArgsConstructor
public class ErrorEntity {

	@Id
	@Column(name="code_error")
	private int codeError;
	
	@Column(name="message")
	private String message;
	
	@Column(name="type_erreur")
	private String typeErreur;
	
	@Column(name="info")
	private String info;

}
