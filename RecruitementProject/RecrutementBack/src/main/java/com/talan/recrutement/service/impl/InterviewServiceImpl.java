package com.talan.recrutement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.recrutement.dto.InterviewDTO;
import com.talan.recrutement.helper.ModelMapperConverter;
import com.talan.recrutement.persistence.entity.InterviewEntity;
import com.talan.recrutement.persistence.repository.InterviewRepository;
import com.talan.recrutement.service.InterviewService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	InterviewRepository interviewRepository;

	@Override
	public List<InterviewDTO> findAllInterviews() {

		List<InterviewEntity> interviews = interviewRepository.findAll((Sort.by(Sort.Direction.DESC, "interviewDate")));
		return interviews.stream().map(interview -> ModelMapperConverter.convertToDTO(interview, InterviewDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public InterviewDTO findInterviewById(int id) {
		InterviewEntity interviewEntity = interviewRepository.findById(id).get();
		return ModelMapperConverter.convertToDTO(interviewEntity, InterviewDTO.class);
	}

	@Override
	public InterviewDTO addInterview(InterviewDTO newInterview) {
		
		InterviewEntity interview = ModelMapperConverter.convertToEntity(newInterview, InterviewEntity.class);
		InterviewEntity interviewEntity = interviewRepository.save(interview);
		
		return ModelMapperConverter.convertToDTO(interviewEntity, InterviewDTO.class);
	}

	@Override
	public void deleteInterview(int id) {

		interviewRepository.deleteById(id);
	}
	


}
