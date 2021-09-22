package uemf.org.Mailing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uemf.org.Models.EtudiantDocumentDTO;

@Getter @Setter 
@AllArgsConstructor 
public class Mail {
	
	private String mailFrom;

	private String mailTo;

	private String mailCc;

	private String mailSubject;

	private String mailContent;

	private String contentType;

	private EtudiantDocumentDTO attachment;
	public Mail() {
		// contentType = "text/plain";
		contentType = "application/xml";
	}


}
