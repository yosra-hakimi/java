package com.talan.recrutement.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Document")
public class DocumentEntity extends ByblosEntities implements Serializable {
	
	  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	
	private byte[] Doc ;
	
	private String docName;

	private String docType;
	
	 
	@OneToOne
	@JoinColumn(name = "application_id")
	@JsonIgnore
	private ApplicationEntity applicationDoc;
	
	
	 public DocumentEntity(String docName, String docType, byte[] Doc) {
	        this.docName = docName;
	        this.docType = docType;
	        this.Doc = Doc;
	    }

	
	public DocumentEntity() {}



    public DocumentEntity(byte[] doc) {
	super();
	this.Doc = doc;
}

}