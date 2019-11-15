package com.talan.recrutement.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.talan.recrutement.delegates.UserTaskDelegate;
import com.talan.recrutement.dto.CandidateDTO;
import com.talan.recrutement.persistence.entity.CandidateEntity;
import com.talan.recrutement.persistence.repository.CandidateRepository;
import com.talan.recrutement.service.impl.CandidateServiceImpl;
import com.talan.recrutement.specification.CandidateSpecificationsBuilder;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

	@Autowired
	private CandidateServiceImpl candidatServiceImpl;
	
	@Autowired
	private UserTaskDelegate userTask;
	

	@Autowired
	private CandidateRepository repo;

	@PostMapping(path = "/candidates", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody CandidateDTO createCandidate(@RequestBody CandidateDTO newCandidate) {
		
		return userTask.createCandidate(newCandidate);

	}
	
	@PostMapping(path = "/candidates/bo/status/update", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody CandidateDTO boStatusUpdate(@RequestBody CandidateDTO newCandidate) {
		
		return userTask.hrEvaluationTask(newCandidate);

	}
	
	@PostMapping(path = "/candidates/evaluation", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody CandidateDTO evaluationUpdate(@RequestBody CandidateDTO newCandidate) {
		
		return userTask.interviewEvalTask(newCandidate);

	}
	
	@PostMapping(path = "/candidates/propal", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody CandidateDTO propalStatusUpdate(@RequestBody CandidateDTO newCandidate) {
		
		return userTask.propalTask(newCandidate);

	}

	@PostMapping(path = "/candidates/update", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody CandidateDTO updateCandidate(@Valid @RequestBody CandidateDTO candidateToUpdate) {
	return candidatServiceImpl.update(candidateToUpdate);
	}

	
	@GetMapping("/candidates/{mail}")
	public @ResponseBody CandidateDTO findCandidateByMail(@PathVariable String mail) {
		return candidatServiceImpl.getCandidateByMail(mail);
	}
	
	@GetMapping("/candidates/delete/{mail}")
	public void deleteCandidateByMail(@PathVariable String mail) {
		 candidatServiceImpl.deleteCandidateByMail(mail);
	}
	
	@GetMapping("/candidates/all")
	public @ResponseBody List<CandidateDTO> findAllCandidats() {
		return candidatServiceImpl.findAllCandidate();
	}


	@RequestMapping(method = RequestMethod.GET, value = "/candidates")
	@ResponseBody
	public List<CandidateEntity> search(@RequestParam(value = "search") String search) {
		
		CandidateSpecificationsBuilder builder = new CandidateSpecificationsBuilder();
		Pattern pattern = Pattern.compile("(\\w+?)(:)(\\w+?),");
		Matcher matcher = pattern.matcher(search + ",");
		System.out.println(matcher);
		while (matcher.find()) {
			
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<CandidateEntity> spec = builder.build();
		//System.out.println(repo.findAll(spec));
		return repo.findAll(spec);
	}
	
	
	@GetMapping(value ="candidates/applications/interviews/{mail}")
	public @ResponseBody List<CandidateDTO> findListInterviewsByUser(@PathVariable String mail) {
		return candidatServiceImpl.findListInterviewsByUser(mail);
	}
	
}
