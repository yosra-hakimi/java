package com.talan.recrutement.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.talan.recrutement.persistence.entity.ApplicationEntity;
import com.talan.recrutement.persistence.entity.CandidateEntity;
import com.talan.recrutement.persistence.entity.DiplomaEntity;
import com.talan.recrutement.persistence.entity.UniversityEntity;

public class CandidateSpecification implements Specification<CandidateEntity> {

	private SearchCriteria criteria;

	public CandidateSpecification(SearchCriteria criteria) {

		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<CandidateEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		if (criteria.getKey().equals("source")) {
			Join<CandidateEntity, ApplicationEntity> join = root.join("application");
			return builder.equal(builder.lower(join.get("source")), criteria.getValue().toString().toLowerCase());
		} else {
			if (criteria.getKey().equals("university")) {
				Join<CandidateEntity, DiplomaEntity> join = root.join("diploma");
				Join<DiplomaEntity, UniversityEntity> join2 = join.join("university");
				return builder.equal(builder.lower(join2.get("universityName")), criteria.getValue().toString().toLowerCase());
			} else {
				if (criteria.getKey().equals("formation")) {
					Join<CandidateEntity, DiplomaEntity> join = root.join("diploma");
					return builder.equal(builder.lower(join.get("formation")), criteria.getValue().toString().toLowerCase());
				} else {

					if (root.get(criteria.getKey()).getJavaType() == String.class) {
						return builder.like(builder.lower(root.<String>get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase() + "%");
					} else {
						return builder.equal(root.get(criteria.getKey()), criteria.getValue());
					}
				}
			}
		}

	}
}
