package com.talan.recrutement.dto;
import com.talan.recrutement.persistence.entity.UniversityEntity;

import lombok.Data;

@Data
public class DiplomaDTO extends ByblosDTO {

	private int id;
	private String formation;
	private String actuelPost;
	private UniversityEntity university;

}
