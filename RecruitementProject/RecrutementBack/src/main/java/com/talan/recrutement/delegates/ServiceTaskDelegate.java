package com.talan.recrutement.delegates;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.talan.recrutement.dto.CandidateDTO;
import com.talan.recrutement.persistence.entity.InterviewEntity;
import com.talan.recrutement.service.impl.CandidateServiceImpl;
import com.talan.recrutement.service.impl.NotificationServiceImpl;

@Component
@Transactional
public class ServiceTaskDelegate {

	@Autowired
	private NotificationServiceImpl mailSenderImpl;

	@Autowired
	private CandidateServiceImpl candidateServiceImpl;

	public void sendRejectionMail(String mail) {
		
		System.out.println("sorrryyyyyyyyyyyyyyy");
		
		CandidateDTO candidate = candidateServiceImpl.getCandidateByMail(mail);
		
		
		String text=   candidate.getCivility()+ " "+candidate.getFirstName() + " " + candidate.getLastName()+",\r\n" + 
				"\r\n" + 
				"En réponse à votre candidature du Date, je suis au regret de devoir vous informer que celle-ci n'a pas été retenue.\r\n" + 
				"\r\n" + 
				"Soyez cependant assuré que cette décision ne met pas en cause vos qualités personnelles, ni même celles de votre formation.\r\n" + 
				"\r\n" + 
				"Nous sommes très sensibles à l'intérêt que vous portez à notre entreprise, et conservons vos coordonnées afin de vous recontacter au besoin.\r\n" + 
				"\r\n" + 
				"Nous vous souhaitons une pleine réussite dans vos recherches futures.\r\n" + 
				"\r\n" + 
				"Veuillez agréer, "+candidate.getCivility()+", l'expression de mes salutations distinguées.";

		System.out.println("rejected " + candidate.getFirstName() + " " + candidate.getLastName());
		System.out.println("*******************************************************************\n");
		mailSenderImpl.sendNotification(mail,"Talan Recrutement",text);
		System.out.println(text);
	}

	public void sendWelcomeMail(String mail) {
		
		CandidateDTO candidate = candidateServiceImpl.getCandidateByMail(mail);
		
		String text=   candidate.getCivility()+ " "+candidate.getFirstName() + " " + candidate.getLastName()+",\r\n" + 
				"\r\n"+"Faisant suite à notre entretien du [date], nous avons le plaisir de vous confirmer votre embauche à compter du "+candidate.getApplication().getDisponibilityDate()+" en qualité de [emploi].\r\n" +
"\r\n" + 
"Votre serez rémunérée conformément à notre convention collective [montant] euros bruts.\r\n" +
"\r\n" + 
"La période d'essai est de [nombre] mois au cours de laquelle les parties auront la possibilité de rompre unilatéralement le contrat sans respecter de délai de préavis.\r\n" +
"\r\n" + 
"Vous trouverez ci-joint deux exemplaires de votre contrat à dater et à signer.\n\r" +
"\r\n" + 
"Je vous prie d'agréer, "+candidate.getCivility()+" mes salutations distinguées.\n\r";

		System.out.println("accepted " + candidate.getFirstName() + " " + candidate.getLastName());
		
		System.out.println("you start at "+candidate.getApplication().getDisponibilityDate());
		System.out.println("*******************************************************************\n");
		//mailSenderImpl.sendNotification(mail,"Talan Recrutement",text);
		System.out.println(text);
	}

	public void sendInvitationMail(String mail) {
		
		CandidateDTO candidate = candidateServiceImpl.getCandidateByMail(mail);

		List<InterviewEntity> interviews = candidate.getApplication().getInterview();
		Collections.sort(interviews, new Comparator<InterviewEntity>() {
public int compare(InterviewEntity o1, InterviewEntity o2) 
{
                return o2.getInterviewDate().compareTo(o1.getInterviewDate());
        }
    });

		System.out.println("invited " + candidate.getFirstName() + " " + candidate.getLastName());
		System.out.println("you must be in our local at "+interviews.get(0).getInterviewDate());
		System.out.println("*******************************************************************\n");
		String text = candidate.getCivility()+ " "+candidate.getFirstName() + " " + candidate.getLastName()+",\r\n" + 
				"\r\n" + 
				"Votre candidature  au sein de notre société a retenu toute notre attention et nous souhaiterions"+
				" vous rencontrer. Nous vous proposons un entretien avec Mme/M. "+
				"(nom), (fonction dans l'entreprise), "+interviews.get(0).getInterviewDate()+" dans nos locaux situés au (adresse) à (ville).";
		//mailSenderImpl.sendNotification(mail,"Talan Recrutement",text);
		System.out.println(text);
	
	}

	public void updateCalendar(String mail) {

		CandidateDTO candidate = candidateServiceImpl.getCandidateByMail(mail);
		
		List<InterviewEntity> interviews = candidate.getApplication().getInterview();
		Collections.sort(interviews, new Comparator<InterviewEntity>() {
public int compare(InterviewEntity o1, InterviewEntity o2) 
{
                return o2.getInterviewDate().compareTo(o1.getInterviewDate());
        }
    });

		System.out.println("calendar updated , you have interview at " + interviews.get(0).getInterviewDate());
		System.out.println("*******************************************************************\n");
	}

	public String getUpdatedCandidat(String mail) {
		System.out.println(mail);
		
		
		System.out.println("*******************************************************************\n");
		System.out.println("status   :" + candidateServiceImpl.getCandidateByMail(mail).getStatut());

		System.out.println("status   :"
				+ candidateServiceImpl.getCandidateByMail(mail).getApplication().getNextStep());

		System.out.println("*******************************************************************\n");
		return candidateServiceImpl.getCandidateByMail(mail).getApplication().getNextStep();

	}
}
