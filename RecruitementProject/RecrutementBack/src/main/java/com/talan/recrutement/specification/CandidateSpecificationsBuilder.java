package com.talan.recrutement.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import com.talan.recrutement.persistence.entity.CandidateEntity;

public class CandidateSpecificationsBuilder {

	 private final List<SearchCriteria> params;
	 
	    public CandidateSpecificationsBuilder() {
	        params = new ArrayList<SearchCriteria>();
	    }
	 
	    public CandidateSpecificationsBuilder with(String key, String operation, Object value) {
	        params.add(new SearchCriteria(key, operation, value));
	        return this;
	    }
	 
	    public Specification<CandidateEntity> build() {
	    	System.out.println(params.size());
	    	
	        if (params.size() == 0) {
	            return null;
	        }
	 
	        List<Specification> specs = params.stream().map(CandidateSpecification::new).collect(Collectors.toList());
	         
	        Specification result = specs.get(0);
	 
	        for (int i = 1; i < params.size(); i++) {
	            result = Specification.where(result).and(specs.get(i));
	        }       
	        return result;
	    }
}
