package com.talan.recrutement.helper;

import org.modelmapper.ModelMapper;

import com.talan.recrutement.dto.ByblosDTO;
import com.talan.recrutement.persistence.entity.ByblosEntities;;

public final class ModelMapperConverter {

	static ModelMapper modelMapper = new ModelMapper();

	private ModelMapperConverter() {
	}

	public static <T extends ByblosDTO> T convertToDTO(ByblosEntities Source, Class<T> clazz) {
		return modelMapper.map(Source, clazz);
	}

	public static <T extends ByblosEntities> T convertToEntity(ByblosDTO Source, Class<T> clazz) {
		return modelMapper.map(Source, clazz);
	}

}
