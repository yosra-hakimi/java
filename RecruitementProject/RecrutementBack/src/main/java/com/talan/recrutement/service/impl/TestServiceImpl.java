package com.talan.recrutement.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.talan.recrutement.config.jwtconf.JwtProperties;
import com.talan.recrutement.delegates.UserTaskDelegate;
import com.talan.recrutement.dto.CandidateDTO;
import com.talan.recrutement.persistence.entity.ApplicationEntity;
import com.talan.recrutement.persistence.entity.DiplomaEntity;
import com.talan.recrutement.persistence.entity.InterviewEntity;
import com.talan.recrutement.persistence.entity.UniversityEntity;
import com.talan.recrutement.persistence.entity.UserEntity;
import com.talan.recrutement.persistence.repository.UserRepository;

@Component
public class TestServiceImpl {
	
	@Autowired
	private RuntimeService runTimeService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTaskDelegate userTask;
	
	
	@Autowired
	TaskService taskService;
	
	
	 @Transactional
		public Map<String, String> startProcess(HttpServletRequest request) {
		 
		 	
			
			UserEntity userEntity = getUserEntity(request);
			Map<String, Object> vars = Collections.<String, Object>singletonMap("user", userEntity);
			System.out.println("test");
	        runTimeService.startProcessInstanceByKey("myProcess", vars).getId();
	        Map<String, String> varMap = new HashMap<String, String>();
	        ProcessInstance processInstance = runTimeService.startProcessInstanceByKey("myProcess", vars);
	        
	        varMap.put("process id :", processInstance.getId());
	        TaskQuery query = taskService.createTaskQuery()
                    .processInstanceId(processInstance.getId())
                    .orderByTaskName()
                    .asc();
	        List<Task> tasks = query.list();
	        
	        
	        for(int i=0;i<tasks.size();i++)
	        	varMap.put("Task number "+i, tasks.get(i).getName());
	        
	        
	        System.out.println("start a process");
	        return varMap;
	        
		}
	 
	
	 @Transactional
		public Map<String, String> processUserTask(String processId) {
			System.out.println("executing user task");
			 TaskQuery query = taskService.createTaskQuery()
	                    .processInstanceId(processId)
	                    .orderByTaskName()
	                    .asc();
		        List<Task> tasks = query.list();
		      taskService.complete(tasks.get(0).getId());
		      
		      Map<String,String> valMap = new HashMap<String, String>();
		      valMap.put("process","task passed");
		      
		      return valMap;
			 
		}

		
	@Transactional
	public void processTaskServiceOne(String userName) {
		 System.out.println("process task service 1 started by : "+userName);
		
		 
	}

	@Transactional
	public void processTaskServiceTwo() {
		
		
		System.out.println("process task service 2");
		
		
		
	}

	@Transactional
	public void procthree() {
		System.out.println("process task service 3");
	}




	public Map<String, String> endProcess() {
		Map<String, String> varMap = new HashMap<String, String>();
        varMap.put("response", "end a process");
        System.out.println("userTask");
       
        
        return varMap;
	}
	 private UserEntity getUserEntity(HttpServletRequest request) {
			
			String token = request.getHeader(JwtProperties.HEADER_STRING);
			String username = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET.getBytes())).build()
					.verify(token.replace(JwtProperties.TOKEN_PREFIX, "")).getSubject();
			
			String email = username.split(" ")[2];
			System.out.println(email);
			return userRepository.findById(email).get();
		}
	 
	 
	 
	 
	 private void initDataBase() {
		 
		CandidateDTO candidateDTO = new CandidateDTO();
		
		
		candidateDTO.setStatut("pending");
		candidateDTO.setCivility("M");
		candidateDTO.setFirstName("helmi");
		candidateDTO.setLastName("hmam");
		candidateDTO.setDateFirstExperience(new Date(2004, 10, 05));
		candidateDTO.setDateOfBithday(new Date(1989, 05, 18));
		candidateDTO.setMail("helmi.hmam@yahoo.com");
		candidateDTO.setNationality("Tunisienne");
		candidateDTO.setEntreprise("Talan Tunisie");
		
		
		DiplomaEntity diplomaEntity=new DiplomaEntity();
		diplomaEntity.setActuelPost("JAVA");
		diplomaEntity.setFormation("bac5");
		UniversityEntity universityEntity = new UniversityEntity();
		universityEntity.setId(1);
		diplomaEntity.setUniversity(universityEntity);
		candidateDTO.setDiploma(diplomaEntity);
		
		
		ApplicationEntity applicationEntity =new ApplicationEntity();
		applicationEntity.setApplicationDate(new Date(2019, 06, 30));
		UserEntity userEntity =  new UserEntity();
		userEntity.setMail("ahmed.riahi@yahoo.com");
		applicationEntity.setCooptedBy(userEntity);
		applicationEntity.setDisponibilityDate(new Date(2019, 07, 23));
		applicationEntity.setGeographicalWish("TALAN FRANCE / PARIS");
		userEntity.setMail("ons.mahsni@yahoo.com");
		applicationEntity.setManager(userEntity);
		applicationEntity.setSource("interne");
		
		
		candidateDTO = userTask.createCandidate(candidateDTO);
		
		InterviewEntity interviewEntity = new InterviewEntity();
		
		
		
		
		
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }
	
	

}
