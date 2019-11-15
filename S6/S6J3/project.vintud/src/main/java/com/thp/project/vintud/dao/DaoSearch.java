package com.thp.project.vintud.dao;

import java.util.ArrayList;

import com.thp.project.vintud.entity.impl.SearchImpl;



public interface DaoSearch {
	
	public abstract int addElement(SearchImpl element);

	public abstract ArrayList<SearchImpl> getElement(int id);

	public abstract boolean updateElement(int id,String caseToUpdate,Object newValue);

	public abstract boolean deleteElement(int id);

}
