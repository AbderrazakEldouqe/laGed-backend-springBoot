package uemf.org.Mailing;

public interface MailService {
	
	public void sendEmail(Mail mail );
	
	 void sendEmailEtudiant(String email, Long idFile ) throws Exception;
	

}
