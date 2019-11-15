package com.talan.recrutement.service.impl;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.talan.recrutement.dto.ApplicationDTO;
import com.talan.recrutement.dto.CandidateDTO;
import com.talan.recrutement.dto.DocumentDTO;
import com.talan.recrutement.helper.ModelMapperConverter;
import com.talan.recrutement.persistence.entity.ApplicationEntity;
import com.talan.recrutement.persistence.entity.CandidateEntity;
import com.talan.recrutement.persistence.entity.DocumentEntity;
import com.talan.recrutement.persistence.repository.ApplicationRepository;
import com.talan.recrutement.persistence.repository.CandidateRepository;
import com.talan.recrutement.persistence.repository.DocumentRepository;

@Service
public class DBFileStorageServiceImpl {

    @Autowired
    private ApplicationRepository applicationRepository;
    
    @Autowired
    private CandidateServiceImpl candidateServiceImpl;

    @Autowired
    private DocumentRepository documentRepository;
    
    @Autowired
    private CandidateRepository candidateRepository;
    
    

    public ApplicationDTO storeFile(MultipartFile file) throws IOException {
    	
    	   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
           
    	   ApplicationEntity applicationEntity = new ApplicationEntity( fileName, file.getContentType(),file.getBytes());
       	
           
            
            applicationEntity =  applicationRepository.save(applicationEntity);
            
            return ModelMapperConverter.convertToDTO(applicationEntity, ApplicationDTO.class);
        
            
        } 
    
    

    public CandidateDTO storeFileinCandidat(MultipartFile file,String mail) throws IOException {
    	
    	   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    	
    	CandidateEntity  candidateEntity = new CandidateEntity();
            	 
    	
    	CandidateDTO candidateDto = candidateServiceImpl.getCandidateByMail(mail);
  	
    	candidateDto.getApplication().setFileName(fileName);
    	candidateDto.getApplication().setFileType(file.getContentType());
    	candidateDto.getApplication().setCurriculumVitae(file.getBytes());
        
          candidateServiceImpl.update(candidateDto);
        
        return ModelMapperConverter.convertToDTO(candidateEntity, CandidateDTO.class);
        
    
        
    } 
    
    

 
    public DocumentDTO saveDoc(MultipartFile doc) throws IOException {
    	// Normalize file name
        String docName = StringUtils.cleanPath(doc.getOriginalFilename());
        
    	DocumentEntity documentEntity = new DocumentEntity( docName, doc.getContentType(),doc.getBytes());
  
    	   documentEntity =  documentRepository.save(documentEntity);
        
    	   return ModelMapperConverter.convertToDTO(documentEntity, DocumentDTO.class);
    
        
    } 
    
 
   
	public DocumentDTO getDocument(int docId) {
		DocumentEntity documentEntity = documentRepository.findById(docId).get();
		return ModelMapperConverter.convertToDTO(documentEntity, DocumentDTO.class);
	}
    
    
	public ApplicationDTO getFile(int fileId) {
		//this.applicationRepository.findAll();
		ApplicationEntity applicationEntity = applicationRepository.findById(fileId).get();
		return ModelMapperConverter.convertToDTO(applicationEntity, ApplicationDTO.class);
	}
    
	

	


	public CandidateDTO getCvByMail(String candidateId) {
		CandidateEntity candidateEntity = candidateRepository.findById(candidateId).get();
		return ModelMapperConverter.convertToDTO(candidateEntity, CandidateDTO.class);
	}
	
	



    }




   
