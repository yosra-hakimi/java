package com.talan.recrutement.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.talan.recrutement.dto.ApplicationDTO;
import com.talan.recrutement.dto.CandidateDTO;
import com.talan.recrutement.dto.DocumentDTO;
import com.talan.recrutement.persistence.entity.ApplicationEntity;
import com.talan.recrutement.persistence.entity.CandidateEntity;
import com.talan.recrutement.service.impl.DBFileStorageServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;









@RestController
@CrossOrigin
public class FileController {

	
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private DBFileStorageServiceImpl dbFileStorageService;

	
	@PostMapping("/uploadFile/{mail}")
	public CandidateDTO uploadFile(@RequestParam("file") MultipartFile file,@PathVariable String mail) {
		
	
			try {
				return dbFileStorageService.storeFileinCandidat(file, mail);
			} catch (IOException e) {

				e.printStackTrace();
			}
		return null;

		
		
	}
	
	
	 
	 @GetMapping("/downloadFileByMail/{candidateId}")
	    public CandidateDTO downloadFileByMail(@PathVariable String candidateId) {
			
			return  dbFileStorageService.getCvByMail(candidateId);
			
	 }
	 
	 
	
	


    @PostMapping("/uploadCvByMail/{mail}")
    public CandidateDTO uploadCvByMail(@RequestParam("file") MultipartFile file,@PathVariable String mail)  {
    	CandidateDTO candidatWithCV = null;
    	String message;
		try {
			candidatWithCV =   dbFileStorageService.storeFileinCandidat(file, mail);
			  message = "You successfully uploaded " + file.getOriginalFilename() + "!";
		} catch (IOException e) {
		
			   message = "FAIL to upload " + file.getOriginalFilename() + "!";
			     
		}
		

        

        System.out.println(file.getName()) ;
           System.out.println(message);
        
        return candidatWithCV;
    }
    
    
    
	 @GetMapping("/downloadCvByMail/{mail}")
	    public ResponseEntity<Resource> downloadCvByMail(@PathVariable String mail) {
		 CandidateDTO candidateDto = new CandidateDTO() ;
		 ApplicationDTO applicationDTO = new ApplicationDTO() ;
		 
		 
		 candidateDto =   dbFileStorageService.getCvByMail(mail) ;
		 
		 return ResponseEntity.ok()
				    .contentType(MediaType.parseMediaType(candidateDto.getApplication().getFileType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + candidateDto.getApplication().getFileName() + "\"")
	                .body(new ByteArrayResource(candidateDto.getApplication().getCurriculumVitae()));	
		
	    }
	 
    
	
	/*

	
	@PostMapping("/uploadMultipleFiles")
	public List<ApplicationDTO> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		System.out.println("got " + files.length + " files");

		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());

	}*/
	
	

	 @GetMapping("/downloadFile/{applicationId}")
	    public ApplicationDTO downloadFile(@PathVariable int applicationId) {
			
			return  dbFileStorageService.getFile(applicationId);
	
		
	    }

	
	

	 @GetMapping("/downloadDoc/{applicationId}")
	    public DocumentDTO downloadDoc(@PathVariable int applicationId) {
			
			return  dbFileStorageService.getDocument(applicationId);
	
	    }
	 
	 

 
	    
	 
	    @GetMapping("/downloadDocument/{applicationId}")
	    public ResponseEntity<Resource> downloadDocument(@PathVariable int applicationId) {
	    	DocumentDTO documentDTO ;
	    	
	        // Load file from database
	    	
	    	documentDTO = dbFileStorageService.getDocument(applicationId) ;
	        return ResponseEntity.ok()
	               .contentType(MediaType.parseMediaType(documentDTO.getDocType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documentDTO.getDocName() + "\"")
	                .body(new ByteArrayResource(documentDTO.getDoc()));
	    }
	    
	    
		 
		 @GetMapping("/downloadCv/{applicationId}")
		    public ResponseEntity<Resource> downloadCv(@PathVariable int applicationId) {
			 ApplicationDTO applicationDTO ;
			 
			 applicationDTO =  dbFileStorageService.getFile(applicationId) ;
			 
			 return ResponseEntity.ok()
		            //  .contentType(MediaType.parseMediaType(applicationDTO.getFileType()))
					    .contentType(MediaType.APPLICATION_PDF)
		                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + applicationDTO.getFileName() + "\"")
		                .body(new ByteArrayResource(applicationDTO.getCurriculumVitae()));	
			
		    }
    
		 
		 
		    
		    @PostMapping("/uploadCv")
		    public ApplicationDTO uploadCv(@RequestParam("file") MultipartFile file)  {
		    	 String message ;
		    	 ApplicationDTO applicationDTO = null;
				try {
					applicationDTO = dbFileStorageService.storeFile(file);
					  message = "You successfully uploaded " + file.getOriginalFilename() + "!";
				} catch (IOException e) {
				
					   message = "FAIL to upload " + file.getOriginalFilename() + "!";
					     
				}
				

		        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		                .path("/downloadCv/")
		                .path(applicationDTO.getFileName())
		                .toUriString();

		        System.out.println(file.getName()) ;
		           System.out.println(message);
		        
		        return new ApplicationDTO(applicationDTO.getFileName(), fileDownloadUri , file.getContentType() , file.getSize() );
		    } 
		    
		    
			@PostMapping("/uploadMultipleCv")
			public List<ApplicationDTO> uploadMultipleCv(@RequestParam("files") MultipartFile[] files) {
				System.out.println("got " + files.length + " files");

				return Arrays.asList(files).stream().map(file -> uploadCv(file)).collect(Collectors.toList());
			}
	    
			
	    @PostMapping("/uploadDoc")
	    public DocumentDTO uploadDoc(@RequestParam("doc") MultipartFile doc)  {
	    	 String message ;
	    	DocumentDTO documentDTO = null;
			try {
				documentDTO = dbFileStorageService.saveDoc(doc);
				  message = "You successfully uploaded " + doc.getOriginalFilename() + "!";
			} catch (IOException e) {
			
				   message = "FAIL to upload " + doc.getOriginalFilename() + "!";
				     
			}

	        String DocDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(documentDTO.getDocName())
	                .toUriString();

	        System.out.println(doc.getName()) ;
	        
	        return new DocumentDTO(documentDTO.getDocName(), DocDownloadUri , doc.getContentType() , doc.getSize() );
	    }  
	    
	
	    
	    
		@PostMapping("/uploadMultipleDoc")
		public List<DocumentDTO> uploadMultipleDoc(@RequestParam("docs") MultipartFile[] docs) {
			System.out.println("got " + docs.length + " docs");

			return Arrays.asList(docs).stream().map(doc -> uploadDoc(doc)).collect(Collectors.toList());

		} 
		
		
	

	

	
		
	
		
		

}