package com.talan.recrutement.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface TestService {
	
	public Map<String, String> startProcess(HttpServletRequest request);
	
	public void processTaskServiceOne();
	
	public void processTaskServiceTwo();
	
	public void processTaskServiceThree();
	
	public Map<String, String> processUserTask();
	
	public Map<String, String> endProcess();
	

}
