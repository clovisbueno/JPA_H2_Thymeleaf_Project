package com.clovisbueno.demo.dao;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clovisbueno.demo.model.Trees;

public interface treeRepo extends JpaRepository<Trees, Long> {

	//public List<Trees> findAllByOrderByIdAsc();
	//Product findByName(String productName);
	

}
