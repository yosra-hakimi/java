package com.talan.recrutement.dto;



import lombok.Data;

@Data
public class DocumentDTO extends ByblosDTO{
	

	
	private int id;
	private byte[] doc;
	private String docName;
    private String docDownloadUri ;
    private  String docType ;
    private long size ;

    
	
	public DocumentDTO() {
	
	}

	public DocumentDTO(String docName, String docDownloadUri, String docType, long size) {

		this.docName = docName ;
		this.docDownloadUri = docDownloadUri ;
		this.docType = docType ;
		this.size = size ;
	}



    public DocumentDTO(String docName, String docType, byte[] doc) {
        this.docName = docName;
        this.docType = docType;
        this.doc = doc;
    }
    

    
	
}



