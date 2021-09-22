package uemf.org.Mailing;

public class MailContentEtudient implements MailContent{


	@Override
	public String getNotification() {
		return "Bonjour, <br><br> Vous Trouvez en PJ le document"
				
				
				+ "<br><br>" + "Cordialement," ;
	}


	public String getSubjectNotification() {
		StringBuffer subject = new StringBuffer();
		
			subject.append("Document Etudiant");
			
		return subject.toString();
	}


	

	

	
	
}
