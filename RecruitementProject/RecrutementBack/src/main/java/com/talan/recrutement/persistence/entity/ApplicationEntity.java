package com.talan.recrutement.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "application")
public class ApplicationEntity extends ByblosEntities implements Serializable {

	private static final long serialVersionUID = 1L;
	/********* Variables ********/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	/* jointure */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manager_id")
	private UserEntity manager;

	@Column(name = "source")
	private String source;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "copter_id" , nullable = true )
	private UserEntity cooptedBy;

	@Column(name = "application_date")
	private Date applicationDate;

	@Column(name = "disponibility_date")
	private Date disponibilityDate;

	@Column(name = "curriculum_vitae")
	private byte[] curriculumVitae;

	@Column(name = "geographical_wish")
	private String geographicalWish;

	@Column(name = "nextStep")
	private String nextStep;

	@JoinColumn(name = "searched_position")
	private String searchedPosition;

	


	@OneToMany( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<InterviewEntity> interview = new ArrayList<InterviewEntity>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationDoc", cascade = CascadeType.ALL)
	private List<DocumentEntity> document = new ArrayList<DocumentEntity>();
	
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "file_type")
	private String fileType;
	
	
	
	 public ApplicationEntity(String fileName, String fileType, byte[] curriculumVitae) {
	        this.fileName = fileName;
	        this.fileType = fileType;
	        this.curriculumVitae = curriculumVitae;
	    }

	public ApplicationEntity() {
	}

    public ApplicationEntity(byte[] curriculumVitae) {
	super();
	this.curriculumVitae = curriculumVitae;
}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationEntity other = (ApplicationEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

}
