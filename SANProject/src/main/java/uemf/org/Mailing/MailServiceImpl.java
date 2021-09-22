package uemf.org.Mailing;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uemf.org.Models.EtudiantDocumentDTO;
import uemf.org.Services.EtudiantDocumentService;
import org.springframework.mail.javamail.JavaMailSender;

@Service
@Slf4j
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	EtudiantDocumentService etudiantDocumentService;

	public void sendEmail(Mail mail)  {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			mimeMessageHelper.setSubject(mail.getMailSubject());
		//	mimeMessageHelper.setFrom(
				//	new InternetAddress("cheramatlaila93@gmail.com", "UEMF"));
			if (mail.getMailTo().contains(";")) {
				String[] mails = mail.getMailTo().replace(" ", "").split(";");
				mimeMessageHelper.setTo(mails);
			} else {
				mimeMessageHelper.setTo(mail.getMailTo().trim());
			}

			if (mail.getMailCc() != null && !mail.getMailCc().isEmpty()) {

				if (mail.getMailCc().contains(";")) {
					String[] mails = mail.getMailCc().replace(" ", "").split(";");
					mimeMessageHelper.setCc(mails);
				} else {
					mimeMessageHelper.setCc(mail.getMailCc().trim());
				}
			}
			if(mail.getAttachment()!=null) {
				        FileSystemResource file = new FileSystemResource(mail.getAttachment().getCheminDoc());
				        mimeMessageHelper.addAttachment(file.getFilename(), file);
				}
			
			mimeMessageHelper.setText(mail.getMailContent(), true);
			mailSender.send(mimeMessageHelper.getMimeMessage());

		} catch (MessagingException e) {
			e.printStackTrace();	
			}

	}

	public void sendEmailEtudiant(String email, Long idFile ) throws Exception {
		
		    log.info("DEBUT DE LA METHODE sendEmailEtudiant !");
			Mail mail = new Mail();
			
			MailContent content = new MailContentEtudient();
			mail.setMailSubject(content.getSubjectNotification());
			mail.setMailContent(content.getNotification());
			EtudiantDocumentDTO  etudiantDocumentDTO= etudiantDocumentService.getDocumentById(idFile);
			mail.setAttachment(etudiantDocumentDTO);
			mail.setMailTo(email);
			try {
				log.info("ENVOIE DU MAIL A : {} ", email);
				  sendEmail(mail);
				  log.info("mail success !");
			} catch (Exception e) {
				log.error("ERROR HORS DE LA METHODE sendEmailEtudiant : "+e.getMessage());
				throw new Exception("Erreur de l'envoi du Mail");
			}
			
		}
	}


