package com.talan.recrutement.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.talan.recrutement.persistence.entity.CandidateEntity;
import com.talan.recrutement.persistence.entity.DocumentEntity;
import com.talan.recrutement.persistence.entity.InterviewEntity;
import com.talan.recrutement.persistence.entity.UserEntity;

import lombok.Data;

@Data
public class ApplicationDTO extends ByblosDTO {

	public ApplicationDTO(byte[] curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}
	
	
	public ApplicationDTO() {}
	

	 
	 
		public ApplicationDTO(String fileName, String cvDownloadUri, String fileType, long size) {

			this.fileName = fileName ;
			this.fileDownloadUri = cvDownloadUri ;
			this.fileType = fileType ;
			this.size = size ;
		}

		
		 public ApplicationDTO(String fileName, String fileType, byte[] curriculumVitae) {
		        this.fileName = fileName;
		        this.fileType = fileType;
		        this.curriculumVitae = curriculumVitae;
		    }
		 
	private int id;
	private UserEntity manager;
	private String source;
	private UserEntity cooptedBy;
	private Date applicationDate;
	private Date disponibilityDate;
	private byte[] curriculumVitae;
	private String geographicalWish;
	private String searchedPosition;
	private CandidateEntity candidate;
	private List<InterviewEntity> interview = new ArrayList<InterviewEntity>();
	private List<DocumentEntity> document = new ArrayList<DocumentEntity>();
	
	private String fileName;
	private String fileType;
    private long size ;
    private String fileDownloadUri ;
	


	private String nextStep;

}
