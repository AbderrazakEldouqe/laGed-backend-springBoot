package uemf.org.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_GEN")
	private Long idError;
	private int code;
	private String message;
	private String typeErreur;
	private String info;
}
