package com.talan.recrutement.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.talan.recrutement.delegates.UserTaskDelegate;
import com.talan.recrutement.dto.CandidateDTO;
import com.talan.recrutement.persistence.entity.RoleEntity;
import com.talan.recrutement.service.impl.NotificationServiceImpl;
import com.talan.recrutement.service.impl.TestServiceImpl;

@RestController
@CrossOrigin
public class TestController {

	@Autowired
	private TestServiceImpl testService;

	@Autowired
	private UserTaskDelegate userTask;
	
	@Autowired
	private NotificationServiceImpl mailSenderImpl;
	
	
	@RequestMapping(value = "/test/mail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void executePropalUserTask(@RequestBody Map<String, String> req) {
		
		
		String receiver = req.get("receiver");
		String subject ="test mail";
		String text = req.get("text");
		mailSenderImpl.sendNotification(receiver, subject, text);
	}

	@GetMapping(path = "/test/auth", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RoleEntity testAuth() {

		RoleEntity role = new RoleEntity();
		role.setId(25);
		role.setRoleName("authentifier");
		return role;

	}
	
	
	

	@GetMapping(path = "/test/admin", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RoleEntity testAdmin() {

		RoleEntity role = new RoleEntity();
		role.setId(25);
		role.setRoleName("authentifier et admin");
		return role;

	}

	@GetMapping(path = "/test/eval", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RoleEntity testEval() {

		RoleEntity role = new RoleEntity();
		role.setId(25);
		role.setRoleName("authentifier et évaluateur");
		return role;

	}

	@RequestMapping(value = "/test/process/start", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> startMyProcess(HttpServletRequest req) {

		return testService.startProcess(req);

	}

	@RequestMapping(value = "/test/recrutement/process/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CandidateDTO executeCreateUserTask(@RequestBody CandidateDTO newCandidateDTO) {

		return userTask.createCandidate(newCandidateDTO);

	}

	@RequestMapping(value = "/test/recrutement/process/bo/status/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void executeHrEvalUserTask(@RequestBody CandidateDTO req) {

		userTask.hrEvaluationTask(req);

	}
	
	@RequestMapping(value = "/test/recrutement/process/propal/status/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void executePropalUserTask(@RequestBody CandidateDTO req) {

		userTask.propalTask(req);
	}
	
	
	@RequestMapping(value = "/test/recrutement/process/plan/status/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void executeInterviewPlanUserTask(@RequestBody CandidateDTO req) {

		userTask.interviewPlanTask(req);

	}
	
	@RequestMapping(value = "/test/recrutement/process/eval/status/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void executeInterviewEvalUserTask(@RequestBody CandidateDTO req) {

		userTask.interviewEvalTask(req);

	}
	
	
	

}
