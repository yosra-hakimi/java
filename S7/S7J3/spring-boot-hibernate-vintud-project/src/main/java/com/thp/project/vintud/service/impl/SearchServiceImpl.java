package com.thp.project.vintud.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.project.vintud.entity.impl.SearchImpl;
import com.thp.project.vintud.service.SearchService;


@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class SearchServiceImpl implements SearchService {

	@Override
	public int addElement(SearchImpl element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<SearchImpl> getElement(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateElement(int id, String caseToUpdate, Object newValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteElement(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
