package com.clovisbueno.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.clovisbueno.demo.dao.treeRepo;
import com.clovisbueno.demo.model.Trees;

@Service
public class TreeService {

	
	@Autowired
	private treeRepo repository;
	
	public List<Trees> findAll() {
		return repository.findAll(sortByLocationAsc());
	}
	
	private Sort sortByLocationAsc() {
		return new Sort(Sort.Direction.ASC, "location");
	}
	
	public Trees findOne(Long id) {
		return repository.findById(id).orElse(new Trees());
	}
	
	public Trees save(Trees tree) {
		return repository.saveAndFlush(tree);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}