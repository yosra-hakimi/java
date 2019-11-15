package com.talan.recrutement.delegates;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.talan.recrutement.dto.CandidateDTO;
import com.talan.recrutement.service.impl.CandidateServiceImpl;

@Component
@Transactional
public class UserTaskDelegate {

	@Autowired
	private RuntimeService runTimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private CandidateServiceImpl candidateServiceImpl;

	public CandidateDTO createCandidate(CandidateDTO newCandidate) {

		Map<String, Object> vars = Collections.<String, Object>singletonMap("candidate", newCandidate);
		ProcessInstance processInstance = runTimeService.startProcessInstanceByKey("recrutementProcess", vars);
		newCandidate.setProcessId(processInstance.getId());
		TaskQuery query = taskService.createTaskQuery().processInstanceId(processInstance.getId()).orderByTaskName()
				.asc();
		List<Task> tasks = query.list();

		System.out.println("start a process id: " + processInstance.getId());

		System.out.println("Task number 0 " + tasks.get(0).getName() + " id: " + tasks.get(0).getId() + "\n\n");
		
		System.out.println("*******************************************************************\n");

		taskService.complete(tasks.get(0).getId());
		
		CandidateDTO submitedCandidat=candidateServiceImpl.createCandidate(newCandidate);
		System.out.println(newCandidate.getStatut());
		if(newCandidate.getStatut().equals("interviewPlaned")) {
			System.out.println("tesssssssssssssssssssssssssssstttttttttttttttttttttttttttttttttttttttttttttttttt");
			hrEvaluationTask(newCandidate);
		}
		
		
		

		return submitedCandidat;
	}

	public CandidateDTO hrEvaluationTask(CandidateDTO candidateDTO) {

		TaskQuery query = taskService.createTaskQuery().processInstanceId(candidateDTO.getProcessId()).orderByTaskName()
				.asc();
		List<Task> tasks = query.list();

		System.out.println("Hr Eval " + tasks.get(0).getName() + " id: " + tasks.get(0).getId());
		System.out.println("*******************************************************************\n");
		
		CandidateDTO candidateDTO2 = candidateServiceImpl.update(candidateDTO);
		System.out.println("candidate status " + candidateDTO2.getStatut() + " nextStep "
				+ candidateDTO2.getApplication().getNextStep());
		taskService.complete(tasks.get(0).getId());
		
		return candidateDTO2;

	}

	public CandidateDTO propalTask(CandidateDTO candidateDTO) {

		TaskQuery query = taskService.createTaskQuery().processInstanceId(candidateDTO.getProcessId()).orderByTaskName()
				.asc();
		List<Task> tasks = query.list();

		System.out.println("Propal " + tasks.get(0).getName() + " id: " + tasks.get(0).getId());
		System.out.println("*******************************************************************\n");
		
		CandidateDTO candidateDTO2 = candidateServiceImpl.update(candidateDTO);
		System.out.println("candidate status " + candidateDTO2.getStatut() + " nextStep "
				+ candidateDTO2.getApplication().getNextStep());
		
		taskService.complete(tasks.get(0).getId());
		
		return candidateDTO2;

	}

	public CandidateDTO interviewPlanTask(CandidateDTO candidateDTO) {

		TaskQuery query = taskService.createTaskQuery().processInstanceId(candidateDTO.getProcessId()).orderByTaskName()
				.asc();
		List<Task> tasks = query.list();

		System.out.println("Task number 0 " + tasks.get(0).getName() + " id: " + tasks.get(0).getId());
		System.out.println("*******************************************************************\n");
		
		CandidateDTO candidateDTO2 = candidateServiceImpl.update(candidateDTO);
		System.out.println("candidate status " + candidateDTO2.getStatut() + " nextStep "
				+ candidateDTO2.getApplication().getNextStep());
		taskService.complete(tasks.get(0).getId());
		
		return candidateDTO2;
	}

	public CandidateDTO interviewEvalTask(CandidateDTO candidateDTO) {

		TaskQuery query = taskService.createTaskQuery().processInstanceId(candidateDTO.getProcessId()).orderByTaskName()
				.asc();
		List<Task> tasks = query.list();

		System.out.println("Task number 0 " + tasks.get(0).getName() + " id: " + tasks.get(0).getId());
		System.out.println("*******************************************************************\n");
		
		CandidateDTO candidateDTO2 = candidateServiceImpl.update(candidateDTO);
		System.out.println("candidate status " + candidateDTO2.getStatut() + " nextStep "
				+ candidateDTO2.getApplication().getNextStep());
		taskService.complete(tasks.get(0).getId());
		
		return candidateDTO2;
		
	}

}
