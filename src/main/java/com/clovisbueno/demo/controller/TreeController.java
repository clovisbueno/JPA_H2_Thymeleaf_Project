package com.clovisbueno.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clovisbueno.demo.model.Trees;
import com.clovisbueno.demo.service.TreeService;

@Controller
public class TreeController {

	@Autowired
	TreeService service;
	

	@GetMapping("/")
	public String tree_List(Model model) {
		model.addAttribute("treeList", service.findAll());
		return "startPage.html";
	}
		
	@Query("select t from Trees t order by ISNULL(t.location ,c.species) asc ,t.species")
	public List<Trees> findAll(){
		List<Trees> treeList = new ArrayList<>();
		service.findAll().forEach(treeList::add);
		return treeList;
	}
			
	
	@GetMapping("/add")
	public ModelAndView add(Trees tree) {
		
		ModelAndView mv = new ModelAndView("addTree");
		mv.addObject("tree", tree);
		return mv;
	}
	

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return add(service.findOne(id));
	
	}

	/*A função delete está funcionando, porém retorna a 
	 * startPage.html sem as formatações, parece que não
	 *  consegue inicializar os scripts.*/	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, Model model) {
				
		service.delete(id);
		
		model.addAttribute("treeList", service.findAll());	
		ModelAndView mv = new ModelAndView("startPage");		
		return mv;   
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Trees tree, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return add(tree);
		}
		
		service.save(tree);
		
		model.addAttribute("treeList", service.findAll());
		ModelAndView mv = new ModelAndView("startPage");
		return mv;
	}
}
